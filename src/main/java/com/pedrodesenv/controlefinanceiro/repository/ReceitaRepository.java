package com.pedrodesenv.controlefinanceiro.repository;

import com.pedrodesenv.controlefinanceiro.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/***
 * Author Pedro Gentil
 *
 * ***/

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByDataBetween(LocalDate dtInicio, LocalDate dtFim);
}