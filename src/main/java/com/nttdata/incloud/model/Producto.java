package com.nttdata.incloud.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto")
public class Producto {

	public static final String SEQUENCE_NAME = "producto_sequence";
	
	@Id
	private Long id;
	
	@NotBlank
	private BigDecimal saldo;
	
	private long moviento;

	public Producto() {
	}

	public Producto(Long id, BigDecimal saldo, long moviento) {
		this.id = id;
		this.saldo = saldo;
		this.moviento = moviento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public long getMoviento() {
		return moviento;
	}

	public void setMoviento(long moviento) {
		this.moviento = moviento;
	}

}
