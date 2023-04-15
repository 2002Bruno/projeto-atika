package com.example.soldier.soldier.service;

import com.example.soldier.soldier.entity.Categoria;
import com.example.soldier.soldier.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public void cadastrar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
