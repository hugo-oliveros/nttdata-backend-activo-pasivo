package com.nttdata.incloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "cliente")
public class Cliente {

	public static final String SEQUENCE_NAME = "cliente_sequence";

	@Id
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String nombre;

	@NotBlank
	@Size(max = 100)
	private String apellido;

	@Size(max = 200)
	private String direccion;

	@Size(max = 15)
	private String telefono;

}
