package com.example.soldier.soldier.dto.request;

import com.example.soldier.soldier.entity.pessoa.Endereco;
import lombok.Data;

@Data
public class PessoaRequest {

    private Long id;

    private String nome;

    private Endereco endereco;
}
