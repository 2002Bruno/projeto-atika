package com.example.soldier.soldier.controller.IController;

import com.example.soldier.soldier.request.CategoriaRequest;
import com.example.soldier.soldier.response.CategoriaResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ICategoriaController {

    @PostMapping
    ResponseEntity<?> cadastrarCategorias(@Valid @RequestBody CategoriaRequest categoriaRequest);

    @GetMapping("/todas")
    ResponseEntity<?> listarCategorias();

    @PutMapping
    ResponseEntity editarCategorias(@RequestBody CategoriaRequest categoriaRequest);


    @DeleteMapping("/{id}")
    void deletarCategoria(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable Long id);
}
