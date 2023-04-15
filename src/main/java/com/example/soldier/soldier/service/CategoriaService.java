package com.example.soldier.soldier.service;

import com.example.soldier.soldier.entity.Categorias;
import com.example.soldier.soldier.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public void cadastrar(Categorias categorias) {
        categoriaRepository.save(categorias);
    }

    public void editar(Categorias categorias) {
        categoriaRepository.save(categorias);
    }

    public List<Categorias> listar() {
        return categoriaRepository.findAll();
    }


    public Categorias buscarPorId(Long id) {
        Categorias categorias = categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não Encontrada"));
        return categorias;
    }


    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
