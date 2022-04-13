package com.nttdata.incloud.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pasivo")
public class Pasivos {

	public static final String SEQUENCE_NAME = "pasivo_sequence";
	
	@Id
	private Long id;
	
	@NotBlank
	@Size(max = 200)
	private String descrip;

	public Pasivos() {
	}

	public Pasivos(Long id, String descrip) {
		super();
		this.id = id;
		this.descrip = descrip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public String toString() {
		return "Pasivos [id=" + id + ", descrip=" + descrip + "]";
	}

}
