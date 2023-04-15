package com.example.soldier.soldier.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LancamentoRequest {

    private Long id;

    private String descricao;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    private Long valor;

    private String observacao;
}
