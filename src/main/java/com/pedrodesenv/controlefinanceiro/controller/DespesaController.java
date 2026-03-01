package com.pedrodesenv.controlefinanceiro.controller;

import com.pedrodesenv.controlefinanceiro.model.Despesa;
import com.pedrodesenv.controlefinanceiro.service.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService despesaService;

    @PostMapping
    public Despesa criar(@RequestBody Despesa despesa) {
        return despesaService.salvar(despesa);
    }

    @GetMapping
    public List<Despesa> listar() {
        return despesaService.listar();
    }

    @GetMapping("/{id}")
    public Despesa buscarDespesaPorId(@PathVariable Long id) {
        return despesaService.buscarDespesaPorId(id);
    }

    @GetMapping("/filtro")
    public List<Despesa> listarDespesaPorMes(@RequestParam int mes,
                                             @RequestParam int ano) {
        return despesaService.listarDespesaPorMes(mes, ano);

    }

    @PutMapping("/{id}")
    public Despesa atualizarDespesa(@PathVariable Long id,
                                    @RequestBody Despesa despesa) {
        return despesaService.atualizarDespesa(id, despesa);
    }

    @DeleteMapping("/{id}")
    public void deletarDespesa(@PathVariable Long id) {
        despesaService.deletarDespesa(id);
    }
}