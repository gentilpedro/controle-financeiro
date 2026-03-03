package com.pedrodesenv.controlefinanceiro.controller;

import com.pedrodesenv.controlefinanceiro.enumerate.TipoCategoria;
import com.pedrodesenv.controlefinanceiro.model.Lancamentos;
import com.pedrodesenv.controlefinanceiro.service.LancamentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

/***
 * Author Pedro Gentil
 *
 ***/

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentosController {

    private final LancamentosService lancamentosService;

    @PostMapping
    public Lancamentos criarLancamentos(@Valid @RequestBody Lancamentos lancamento) {
        return lancamentosService.salvar(lancamento);
    }

    @DeleteMapping("/{id}")
    public void deletarLancamento(@PathVariable Long id) {
        lancamentosService.deletar(id);
    }

    @GetMapping
    public List<Lancamentos> listar() {
        return lancamentosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Lancamentos buscarPorId(@PathVariable Long id) {
        return lancamentosService.buscarPorId(id);
    }

    @GetMapping("/filtro")
    public List<Lancamentos> listarPorMes(@RequestParam int mes,
                                          @RequestParam int ano) {
        return lancamentosService.listarPorMes(mes, ano);
    }

    @GetMapping("/filtro-tipo")
    public List<Lancamentos> listarPorTipoEMes(@RequestParam TipoCategoria tipo,
                                               @RequestParam int mes,
                                               @RequestParam int ano) {
        return lancamentosService.listarPorTipoEMes(tipo, mes, ano);
    }

}
