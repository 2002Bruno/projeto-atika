package com.example.soldier.soldier.dto.response;

import com.example.soldier.soldier.entity.Categorias;
import com.example.soldier.soldier.modelmapper.AbstractResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaResponseConverter extends AbstractResponseMapper<Categorias, CategoriaResponse> {

    @Override
    public CategoriaResponse toResponse(Categorias response) {
        return CategoriaResponse.builder()
                .id(response.getId())
                .nome(response.getNome()).build();
    }
}
