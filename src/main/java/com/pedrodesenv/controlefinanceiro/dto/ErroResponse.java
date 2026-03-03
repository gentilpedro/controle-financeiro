package com.pedrodesenv.controlefinanceiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErroResponse {

    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String path;
}