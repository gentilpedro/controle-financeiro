package com.pedrodesenv.controlefinanceiro.controller;

import com.pedrodesenv.controlefinanceiro.model.Receita;
import com.pedrodesenv.controlefinanceiro.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @PostMapping
    public Receita criar(@RequestBody Receita receita) {
        return receitaService.salvar(receita);
    }

    @GetMapping
    public List<Receita> listar() {
        return receitaService.listar();
    }

    @GetMapping("/{id}")
    public Receita buscarReceitaPorId(@PathVariable Long id) {
        return receitaService.buscarReceitaPorId(id);
    }

    @GetMapping("/filtro")
    public List<Receita> listarReceitaPorMes(@RequestParam int mes,
                                             @RequestParam int ano) {
        return receitaService.listarReceitaPorMes(mes, ano);
    }

    @PutMapping("/{id}")
    public Receita atualizarReceita(@PathVariable Long id,
                                    @RequestBody Receita receita) {
        return receitaService.atualizarReceita(id, receita);
    }

    @DeleteMapping("/{id}")
    public void deletarReceita(@PathVariable Long id) {
        receitaService.deletarReceita(id);
    }


}