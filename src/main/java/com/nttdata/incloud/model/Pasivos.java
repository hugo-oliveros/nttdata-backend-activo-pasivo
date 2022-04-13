package com.nttdata.incloud.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "pasivo")
public class Pasivos {

	public static final String SEQUENCE_NAME = "pasivo_sequence";

	@Id
	private Long id;

	@NotBlank
	@Size(max = 200)
	private String descrip;

}
