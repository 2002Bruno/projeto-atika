package com.example.soldier.soldier.controller.IController;

import com.example.soldier.soldier.dto.request.PessoaRequest;
import com.example.soldier.soldier.dto.response.PessoaResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IPessoaController {

    @PostMapping
    ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);

    @GetMapping("/todas")
    ResponseEntity<?> listarPessoas();

    @PutMapping
    ResponseEntity<?> editarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);


    @DeleteMapping("/{id}")
    void deletarPessoa(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<PessoaResponse> buscarPessoaPorId(@PathVariable Long id);
}
