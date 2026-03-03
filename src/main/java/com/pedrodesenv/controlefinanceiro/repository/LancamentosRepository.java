package com.pedrodesenv.controlefinanceiro.repository;

import com.pedrodesenv.controlefinanceiro.model.Lancamentos;
import com.pedrodesenv.controlefinanceiro.enumerate.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LancamentosRepository extends JpaRepository<Lancamentos, Long> {

    List<Lancamentos> findByDataBetween(LocalDate inicio, LocalDate fim);

    List<Lancamentos> findByTipoAndDataBetween(TipoCategoria tipo,
                                               LocalDate inicio,
                                               LocalDate fim);
}