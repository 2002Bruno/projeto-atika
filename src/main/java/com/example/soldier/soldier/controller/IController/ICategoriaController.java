package com.example.soldier.soldier.controller.IController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.soldier.soldier.request.CategoriaRequest;

public interface ICategoriaController {

    @PostMapping
    ResponseEntity cadastrar(@Valid @RequestBody CategoriaRequest categoriaRequest);

    /*@PutMapping
    ResponseEntity editar(@RequestBody PessoaRequest pessoaRequest);

    @GetMapping
    ResponseEntity<List<PessoaResponse>> listar();

    @DeleteMapping("/{id}")
    void deletar(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<PessoaResponse> findById(Long id);

    @GetMapping("/todas")
    ResponseEntity<List<PessoaResponse>> listarTodos();

    @GetMapping("/tecnicos")
    ResponseEntity<List<PessoaResponse>> listarTecnicos();*/
}
