package com.nttdata.incloud.rest.framework;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nttdata.incloud.commons.BindingErrorsResponse;
import com.nttdata.incloud.commons.MessagesUtils;
import com.nttdata.incloud.service.impl.SequenceGeneratorServiceImpl;

import io.swagger.annotations.ApiOperation;

public abstract class CustomRest<T, T2> extends MessagesUtils {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected final String ClassName = this.getClass().getSimpleName();

	protected boolean devuelveRuntimeException = true;

	@Autowired
	protected JPACustomService<T2> repository;

	@Autowired
	private SequenceGeneratorServiceImpl sequenceGeneratorService;

	@ApiOperation(value = "Busca registro de tipo <T2> en base al id enviado", produces = "application/json")
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<T2> findByID(@PathVariable Long id) throws URISyntaxException {
		logger.info("Ingresando findByID %s %s ", this.ClassName, id);
		try {
			return Optional.of(this.repository.get(id)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception error) {
			logger.error(String.format("Error information from MongoDB table Cliente---> %s", error));
			throw new RuntimeException(error);
		}
	}

	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "Lista todos los datos de <T2>", produces = "application/json")
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<T2>> findAll() throws Exception {
		logger.debug("Ingresando findAll %s", this.ClassName);
		try {
			return Optional.ofNullable(new ResponseEntity<List<T2>>(repository.getAll(), HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			logger.error(String.format("Error:%s", e));
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Guarda JSON Array <T2>", produces = "application/json")
	@PostMapping(value = "/saveAll", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<T2>> saveAll(@RequestBody List<T2> entities, BindingResult bindingResult)
			throws URISyntaxException {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		logger.debug("saveAll %s %s", ClassName, entities.toString());
		if (bindingResult.hasErrors()) {
			errors.addAllErrors(bindingResult);
			if (this.devuelveRuntimeException) {
				throw new RuntimeException(errors.toJSON());
			}
			headers.add("errors", errors.toJSON());
			logger.error(String.format("Error:%s", errors.toJSON()));
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		try {
			ResponseEntity<?> responseEntity = new ResponseEntity<Object>(repository.saveAll(entities), HttpStatus.OK);
			return (ResponseEntity<List<T2>>) Optional.ofNullable(responseEntity)
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			if (this.devuelveRuntimeException) {
				String error = getErrorExceptionDebug(e);
				logger.error(String.format("Error : %s", e));
				throw new RuntimeException(error);
			}
			headers = returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Guarda los datos de <T2>", produces = "application/json")
	@PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<T2> save(@RequestBody T2 entities, BindingResult bindingResult) throws URISyntaxException {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors()) {
			errors.addAllErrors(bindingResult);
			if (this.devuelveRuntimeException) {
				logger.error("Error : %s", errors.toJSON());
				throw new RuntimeException(errors.toJSON());
			}
			headers.add("errors", errors.toJSON());
			logger.error("Error : %s", errors.toJSON());
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

		try {
			
			Class<?> c = Class.forName(entities.getClass().getName());
			Field field = c.getField("SEQUENCE_NAME");
			Method aMethod = entities.getClass().getMethod("getId");
			Object aResult = aMethod.invoke(entities);

			if (aResult == null) {
				Method method = c.getDeclaredMethod("setId", Long.class);
				method.invoke(entities, sequenceGeneratorService.generateSequence((String) field.get("SEQUENCE_NAME")));
			}

			return Optional.of(this.repository.save(entities)).map(l -> new ResponseEntity<>(l, HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			if (this.devuelveRuntimeException) {
				String error = getErrorExceptionDebug(e);
				logger.error("Error hace unsave: %s", error);
				throw new RuntimeException(error);
			}
			headers = returnErrorHeaders(e);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Delete por ID", produces = "application/json")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<T2> delete(@PathVariable Long id) throws Exception {
		logger.info("eliminando: %s %s", ClassName, id);
		try {
			return Optional.ofNullable(new ResponseEntity<T2>(repository.delete(id), HttpStatus.OK))
					.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception error) {
			if (this.devuelveRuntimeException) {
				logger.error("Error en eliminar %s %s", ClassName, error);
				throw new RuntimeException(error);
			}
			HttpHeaders headers = this.returnErrorHeaders(error);
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/************************/
	/* Instancia de Bean */
	/************************/
	protected abstract T createInstance();
}