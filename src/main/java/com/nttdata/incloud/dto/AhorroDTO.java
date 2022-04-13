package com.nttdata.incloud.dto;

import com.nttdata.incloud.model.ConsumoMovimiento;
import com.nttdata.incloud.model.Persona;

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
public class AhorroDTO {


	public Persona persona;

	public ConsumoMovimiento consumoMovimiento;


}
