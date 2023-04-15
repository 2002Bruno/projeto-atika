package com.example.soldier.soldier.dto.request;

import com.example.soldier.soldier.entity.Categorias;
import com.example.soldier.soldier.modelmapper.AbstractEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRequestConverter extends AbstractEntityMapper<CategoriaRequest, Categorias> {
    @Override
    public Categorias toEntity(CategoriaRequest request) {
        return Categorias.builder()
                .id(request.getId())
                .nome(request.getNome())
                .build();
    }
}
