package com.nttdata.incloud.dto;

import com.nttdata.incloud.model.Empresa;

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
public class PasivosRequestDTO {

	@Getter
	@Setter
	public String nombre;
	
	@Getter
	@Setter
	public Empresa empresa;

}
