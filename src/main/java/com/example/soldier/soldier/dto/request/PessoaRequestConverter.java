package com.example.soldier.soldier.dto.request;

import com.example.soldier.soldier.entity.pessoa.Endereco;
import com.example.soldier.soldier.entity.pessoa.Pessoa;
import com.example.soldier.soldier.modelmapper.AbstractEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class PessoaRequestConverter extends AbstractEntityMapper<PessoaRequest, Pessoa> {
    @Override
    public Pessoa toEntity(PessoaRequest request) {
        return Pessoa.builder()
                .id(request.getId())
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .build();
    }
}
