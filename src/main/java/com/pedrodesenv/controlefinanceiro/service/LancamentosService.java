package com.pedrodesenv.controlefinanceiro.service;

import com.pedrodesenv.controlefinanceiro.exception.RegraNegocioException;
import com.pedrodesenv.controlefinanceiro.model.Lancamentos;
import com.pedrodesenv.controlefinanceiro.enumerate.TipoCategoria;
import com.pedrodesenv.controlefinanceiro.repository.LancamentosRepository;
import com.pedrodesenv.controlefinanceiro.Util.Mensagens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

/***
 *
 * Author Pedro Gentil
 *
 */

@Service
@RequiredArgsConstructor
public class LancamentosService {

    private final LancamentosRepository lancamentoRepository;

    public Lancamentos salvar(Lancamentos lancamento) {
       if (!lancamento.getCategoria().getTipoCategoria().equals(lancamento.getTipoCategoria()) ) {
           throw new RegraNegocioException(Mensagens.CATEGORIA_INCOMPATIVEL);
       }
                    return lancamentoRepository.save(lancamento);
    }

    public List<Lancamentos> listarTodos() {
        return lancamentoRepository.findAll();
    }

    public Lancamentos buscarPorId(Long id) {
        return lancamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(Mensagens.LANCAMENTO_NAO_ENCONTRADO));
    }

    public void deletar(Long id) {
        Lancamentos lancamento = buscarPorId(id);
        lancamentoRepository.delete(lancamento);
    }

    public List<Lancamentos> listarPorMes(int mes, int ano) {
        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate inicio = yearMonth.atDay(1);
        LocalDate fim = yearMonth.atEndOfMonth();

        return lancamentoRepository.findByDataBetween(inicio, fim);
    }

    public List<Lancamentos> listarPorTipoEMes(TipoCategoria tipo,
                                               int mes,
                                               int ano) {

        YearMonth yearMonth = YearMonth.of(ano, mes);

        LocalDate inicio = yearMonth.atDay(1);
        LocalDate fim = yearMonth.atEndOfMonth();

        return lancamentoRepository
                .findByTipoAndDataBetween(tipo, inicio, fim);
    }
}