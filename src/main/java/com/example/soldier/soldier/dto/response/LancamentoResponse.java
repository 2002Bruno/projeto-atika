package com.example.soldier.soldier.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoResponse {

    private Long id;

    @NotNull
    private String descricao;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    private Long valor;

    private String observacao;
}
