package com.example.soldier.soldier.service;

import com.example.soldier.soldier.entity.Categoria;
import com.example.soldier.soldier.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public void cadastrar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void editar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }


    public Categoria buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não Encontrada"));
        return categoria;
    }


    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
