package com.example.soldier.soldier.dto.response;

import com.example.soldier.soldier.entity.pessoa.Pessoa;
import com.example.soldier.soldier.modelmapper.AbstractResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class PessoaResponseConverter extends AbstractResponseMapper<Pessoa, PessoaResponse> {

    @Override
    public PessoaResponse toResponse(Pessoa response) {
        return PessoaResponse.builder()
                .id(response.getId())
                .nome(response.getNome())
                .status(response.getStatus().getDescricao()).build();
    }
}
