package com.example.soldier.soldier.service;

import com.example.soldier.soldier.entity.pessoa.Pessoa;
import com.example.soldier.soldier.enums.StatusEnum;
import com.example.soldier.soldier.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public void cadastrar(Pessoa categoria) {
        categoria.setStatus(StatusEnum.ATIVO);
        pessoaRepository.save(categoria);
    }

    public void editar(Pessoa categoria) {
        pessoaRepository.save(categoria);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }


    public Pessoa buscarPorId(Long id) {
        Pessoa categoria = pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pessoa não Encontrada"));
        return categoria;
    }


    public void deletar(Long id) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.setStatus(StatusEnum.INATIVO);
        pessoaRepository.save(pessoa);
    }
}
