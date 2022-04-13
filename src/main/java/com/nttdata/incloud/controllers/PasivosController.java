package com.nttdata.incloud.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.incloud.dto.AhorroDTO;
import com.nttdata.incloud.dto.PasivosRequestDTO;
import com.nttdata.incloud.model.ConsumoMovimiento;
import com.nttdata.incloud.model.Pasivos;
import com.nttdata.incloud.rest.framework.CustomRest;
import com.nttdata.incloud.service.ClienteService;
import com.nttdata.incloud.service.ConsumoMovimientoService;
import com.nttdata.incloud.service.PasivosService;
import com.nttdata.incloud.service.PersonaService;
import com.nttdata.incloud.service.impl.SequenceGeneratorServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/Pasivo")
@CrossOrigin("*")
@Api(tags = "Rest de Pasivo", description = "Api Rest que permite hacer CRUD a la tabla de Pasivo.")
public class PasivosController extends CustomRest<PasivosService, Pasivos> {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ConsumoMovimientoService consumoMovimientoService;

	@Autowired
	private SequenceGeneratorServiceImpl sequenceGeneratorService;

	@Override
	protected PasivosService createInstance() {
		return this.createInstance();
	}

	private ConsumoMovimiento consumoMovimiento = new ConsumoMovimiento();

	@ApiOperation(value = "Ahorro: libre de comisión por mantenimiento y con un límite máximo de movimientos mensuales.", produces = "application/json")
	@PostMapping("/CtaBanAhorro/{id}")
	public AhorroDTO CtaBanAhorro(@PathVariable("id") Long id) {

		LocalDate date = LocalDate.now();

		AhorroDTO ahorroDTO = new AhorroDTO();
		log.info("Ingresando a CtaBanAhorro");

		try {
			Optional.of(personaService.get(id)).stream().forEach(persona -> {
				ahorroDTO.setPersona(persona);

				consumoMovimiento = consumoMovimientoService.getAll().stream()
						.filter(mov -> mov.getIdpersona() == persona.getId())
						.max(Comparator.comparing(ConsumoMovimiento::getMoviento))
						.orElseThrow(NoSuchElementException::new);

				consumoMovimiento.setId(sequenceGeneratorService.generateSequence(ConsumoMovimiento.SEQUENCE_NAME));
				consumoMovimiento.setIdpersona(consumoMovimiento.getIdpersona());
				consumoMovimiento.setMoviento(consumoMovimiento.getMoviento() + 1); // Add +1
				consumoMovimiento.setHora(date.toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSS'Z'")));
				consumoMovimiento.setTipo("CtaBanAhorro");
				consumoMovimientoService.save(consumoMovimiento);// save movimiento
				ahorroDTO.setConsumoMovimiento(consumoMovimiento);

				log.info("Ingresando a CtaBanAhorro");
			});

		} catch (java.util.NoSuchElementException e) {
			log.error("Error CtaBanAhorro %s", e);
		}

		return ahorroDTO;
	}

	@GetMapping("/CtaBanCtaCte/{id}")
	@ApiOperation(value = "Cuenta corriente: posee comisión de mantenimiento y sin límite de movimientos mensuales", produces = "application/json")
	public PasivosRequestDTO CtaBanCtaCte(@PathVariable("id") Long id) {
		log.info("Ingresando a CtaBanCtaCte");
		PasivosRequestDTO pasivos = new PasivosRequestDTO();
		return pasivos;
	}

	@GetMapping("/PlazoFijo/{id}")
	@ApiOperation(value = "Plazo fijo: libre de comisión por mantenimiento, solo permite un movimiento de retiro o depósito en un día específico del mes.", produces = "application/json")
	public PasivosRequestDTO PlazoFijo(@PathVariable("id") Long id) {
		log.info("Ingresando a PlazoFijo");
		PasivosRequestDTO pasivos = new PasivosRequestDTO();
		return pasivos;
	}

	private List<ConsumoMovimiento> process(List<ConsumoMovimiento> movimientos,
			Predicate<ConsumoMovimiento> predicate) {
		List<ConsumoMovimiento> result = new ArrayList<ConsumoMovimiento>();
		for (ConsumoMovimiento movimiento : movimientos)
			if (predicate.test(movimiento))
				result.add(movimiento);
		return result;
	}

}
