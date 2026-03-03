package com.pedrodesenv.controlefinanceiro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErroValidacaoResponseDto {

    private LocalDateTime timestamp;
    private int status;
    private List<String> erros;
    private String path;
}
