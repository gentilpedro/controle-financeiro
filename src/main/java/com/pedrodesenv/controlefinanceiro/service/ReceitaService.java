package com.pedrodesenv.controlefinanceiro.service;

import com.pedrodesenv.controlefinanceiro.model.Receita;
import com.pedrodesenv.controlefinanceiro.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;

    public Receita salvar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public List<Receita> listar() {
        return receitaRepository.findAll();
    }

    public Receita buscarReceitaPorId(Long id) {
        return receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));
    }

    public List<Receita> listarReceitaPorMes(int mes, int ano) {

        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate dtInicio = yearMonth.atDay(1);
        LocalDate dtFim = yearMonth.atEndOfMonth();

        return receitaRepository.findByDataBetween(dtInicio, dtFim);
    }

    public Receita atualizarReceita(Long id, Receita receitaAtualizada) {
        Receita receita = buscarReceitaPorId(id);

        receita.setDescricao(receitaAtualizada.getDescricao());
        receita.setValor(receitaAtualizada.getValor());
        receita.setData(receitaAtualizada.getData());

        return receitaRepository.save(receita);
    }

    public void deletarReceita(Long id) {
        Receita receita = buscarReceitaPorId(id);
        receitaRepository.delete(receita);
    }


}