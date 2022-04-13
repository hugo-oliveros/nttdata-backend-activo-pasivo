package com.nttdata.incloud.model;

import java.math.BigDecimal;

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
@Document(collection = "producto")
public class Producto {

	public static final String SEQUENCE_NAME = "producto_sequence";
	
	@Id
	private Long id;
	
	@NotBlank
	private BigDecimal saldo;
	
	private long moviento;

}
