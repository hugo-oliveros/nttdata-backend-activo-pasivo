package com.nttdata.incloud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

	public Cliente() {
	}

	public Cliente(Long id, String nombre, String apellido, String direccion, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}

}
