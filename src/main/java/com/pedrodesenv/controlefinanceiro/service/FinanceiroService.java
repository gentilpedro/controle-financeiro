package com.pedrodesenv.controlefinanceiro.service;

import com.pedrodesenv.controlefinanceiro.dto.ResumoMensalDto;
import com.pedrodesenv.controlefinanceiro.model.Despesa;
import com.pedrodesenv.controlefinanceiro.model.Receita;
import com.pedrodesenv.controlefinanceiro.repository.DespesaRepository;
import com.pedrodesenv.controlefinanceiro.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

@Service
@RequiredArgsConstructor
public class FinanceiroService {

    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    public ResumoMensalDto gerarResumo(int mes, int ano) {

        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate inicio = yearMonth.atDay(1);
        LocalDate fim = yearMonth.atEndOfMonth();

        List<Receita> receitas = receitaRepository.findByDataBetween(inicio, fim);
        List<Despesa> despesas = despesaRepository.findByDataBetween(inicio, fim);

        BigDecimal totalReceitas = receitas.stream()
                .map(Receita::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = despesas.stream()
                .map(Despesa::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldo = totalReceitas.subtract(totalDespesas);

        return new ResumoMensalDto(totalReceitas, totalDespesas, saldo);
    }
}