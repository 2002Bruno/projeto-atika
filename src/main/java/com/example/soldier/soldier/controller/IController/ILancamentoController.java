package com.example.soldier.soldier.controller.IController;

import com.example.soldier.soldier.dto.request.LancamentoRequest;
import com.example.soldier.soldier.dto.response.LancamentoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ILancamentoController {

    @PostMapping
    ResponseEntity<?> cadastrarLancamento(@Valid @RequestBody LancamentoRequest lancamentoRequest);

    @GetMapping("/todas")
    ResponseEntity<?> listarLancamentos();

    @PutMapping
    ResponseEntity<?> editarLancamento(@Valid @RequestBody LancamentoRequest lancamentoRequest);


    @DeleteMapping("/{id}")
    void deletarLancamento(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<LancamentoResponse> buscarLancamentoPorId(@PathVariable Long id);
}
