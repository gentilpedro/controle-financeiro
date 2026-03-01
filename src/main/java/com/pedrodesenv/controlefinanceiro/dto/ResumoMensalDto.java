package com.pedrodesenv.controlefinanceiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

/***
 * Author Pedro Gentil
 *
 * ***/

@Getter
@AllArgsConstructor
public class ResumoMensalDto {

    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;
    private BigDecimal saldo;

}