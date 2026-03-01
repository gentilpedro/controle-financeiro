package com.pedrodesenv.controlefinanceiro.controller;

import com.pedrodesenv.controlefinanceiro.dto.ResumoMensalDto;
import com.pedrodesenv.controlefinanceiro.service.FinanceiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/***
 * Author Pedro Gentil
 *
 * ***/

@RestController
@RequestMapping("/resumo")
@RequiredArgsConstructor
public class FinanceiroController {

    private final FinanceiroService financeiroService;

    @GetMapping
    public ResumoMensalDto gerarResumo(@RequestParam int mes,
                                       @RequestParam int ano) {
        return financeiroService.gerarResumo(mes, ano);
    }
}