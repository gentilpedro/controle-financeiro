package com.pedrodesenv.controlefinanceiro.model;

import com.pedrodesenv.controlefinanceiro.Util.Mensagens;
import com.pedrodesenv.controlefinanceiro.enumerate.TipoCategoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lancamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = Mensagens.DESCRICAO_OBRIGATORIA)
    @Column(nullable = false)
    private String descricao;

    @NotNull(message = Mensagens.VALOR_OBRIGATORIO)
    @Positive(message = Mensagens.VALOR_POSITIVO)
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull(message = Mensagens.DATA_OBRIGATORIA)
    @Column(nullable = false)
    private LocalDate data;

    @NotNull(message = Mensagens.TIPO_OBRIGATORIO)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCategoria tipoCategoria;

    @NotNull(message = Mensagens.CATEGORIA_OBRIGATORIA)
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}