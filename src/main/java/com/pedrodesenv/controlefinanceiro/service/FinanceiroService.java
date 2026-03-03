package com.pedrodesenv.controlefinanceiro.service;

import com.pedrodesenv.controlefinanceiro.dto.ResumoMensalDto;
import com.pedrodesenv.controlefinanceiro.enumerate.TipoCategoria;
import com.pedrodesenv.controlefinanceiro.model.Lancamentos;
import com.pedrodesenv.controlefinanceiro.repository.LancamentosRepository;
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

    private final LancamentosRepository lancamentosRepository;

    public ResumoMensalDto gerarResumo(int mes, int ano){

        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate dtInicio = yearMonth.atDay(1);
        LocalDate dtFim = yearMonth.atEndOfMonth();

        List<Lancamentos>  receitas = lancamentosRepository
                .findByTipoAndDataBetween(TipoCategoria.RECEITA, dtInicio, dtFim );

        List<Lancamentos> despesas = lancamentosRepository
                .findByTipoAndDataBetween(TipoCategoria.DESPESA, dtInicio, dtFim);

        BigDecimal totalReceitas = receitas.stream()
                .map(Lancamentos::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesas = despesas.stream()
                .map(Lancamentos ::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldo = totalReceitas.subtract(totalDespesas);

        return new ResumoMensalDto(totalReceitas, totalDespesas, saldo);
    }
}