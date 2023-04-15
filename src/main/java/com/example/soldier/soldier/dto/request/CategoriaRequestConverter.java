package com.example.soldier.soldier.dto.request;

import com.example.soldier.soldier.entity.Categoria;
import com.example.soldier.soldier.modelmapper.AbstractEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRequestConverter extends AbstractEntityMapper<CategoriaRequest, Categoria> {
    @Override
    public Categoria toEntity(CategoriaRequest request) {
        return Categoria.builder()
                .id(request.getId())
                .nome(request.getNome())
                .build();
    }
}
