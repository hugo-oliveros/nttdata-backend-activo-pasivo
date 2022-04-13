package com.nttdata.incloud.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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

}
