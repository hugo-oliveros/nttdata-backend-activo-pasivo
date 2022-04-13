package com.nttdata.incloud.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "consumoMovimiento")
public class ConsumoMovimiento {

	public static final String SEQUENCE_NAME = "movimiento_sequence";

	@Id
	private Long id;

	@NotBlank
	private int moviento;

	@NotBlank
	private Long idpersona;

	@NotBlank
	private String tipo;

	@NotBlank
	private String hora;

	public ConsumoMovimiento() {
	}

	public ConsumoMovimiento(Long id, @NotBlank int moviento, @NotBlank Long idpersona, @NotBlank String tipo,
			@NotBlank String hora) {
		this.id = id;
		this.moviento = moviento;
		this.idpersona = idpersona;
		this.tipo = tipo;
		this.hora = hora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMoviento() {
		return moviento;
	}

	public void setMoviento(int moviento) {
		this.moviento = moviento;
	}

	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
