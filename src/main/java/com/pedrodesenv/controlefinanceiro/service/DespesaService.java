package com.pedrodesenv.controlefinanceiro.service;

import com.pedrodesenv.controlefinanceiro.model.Despesa;
import com.pedrodesenv.controlefinanceiro.repository.DespesaRepository;
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
public class DespesaService {

    private final DespesaRepository despesaRepository;
    private final ReceitaRepository receitaRepository;

    public Despesa salvar(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public List<Despesa> listar() {
        return despesaRepository.findAll();
    }

    public Despesa buscarDespesaPorId(Long id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    public List<Despesa> listarDespesaPorMes(int mes, int ano) {
        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate dtInicio = yearMonth.atDay(1);
        LocalDate dtFim = yearMonth.atEndOfMonth();

        return despesaRepository.findByDataBetween(dtInicio, dtFim);
    }

    public Despesa atualizarDespesa(Long id, Despesa despesaAtualizada) {
        Despesa despesa = buscarDespesaPorId(id);

        despesa.setDescricao(despesaAtualizada.getDescricao());
        despesa.setValor(despesaAtualizada.getValor());
        despesa.setData(despesaAtualizada.getData());

        return despesaRepository.save(despesa);
    }

    public void deletarDespesa(Long id) {
        Despesa despesa = buscarDespesaPorId(id);
    }


}