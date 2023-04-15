package com.example.soldier.soldier.response;

import com.example.soldier.soldier.entity.Categoria;
import com.example.soldier.soldier.modelmapper.AbstractResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaResponseConverter extends AbstractResponseMapper<Categoria, CategoriaResponse> {

    @Override
    public CategoriaResponse toResponse(Categoria response) {
        return CategoriaResponse.builder()
                .id(response.getId())
                .nome(response.getNome()).build();
    }
}
