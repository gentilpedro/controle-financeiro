package com.pedrodesenv.controlefinanceiro.repository;

import com.pedrodesenv.controlefinanceiro.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findByDataBetween(LocalDate dtInicio, LocalDate dtFim);
}