package com.example.soldier.soldier.service;

import com.example.soldier.soldier.entity.Lancamento;
import com.example.soldier.soldier.repository.LancamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;


    public void cadastrar(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
    }

    public void editar(Lancamento lancamento) {
        lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }


    public Lancamento buscarPorId(Long id) {
        Lancamento lancamento = lancamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lancamento não Encontrada"));
        return lancamento;
    }


    public void deletar(Long id) {
        Lancamento lancamento = buscarPorId(id);
        lancamentoRepository.delete(lancamento);
    }
}
