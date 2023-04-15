package com.example.soldier.soldier.controller;

import com.example.soldier.soldier.controller.IController.ICategoriaController;
import com.example.soldier.soldier.entity.Categoria;
import com.example.soldier.soldier.dto.request.CategoriaRequest;
import com.example.soldier.soldier.dto.request.CategoriaRequestConverter;
import com.example.soldier.soldier.dto.response.CategoriaResponse;
import com.example.soldier.soldier.dto.response.CategoriaResponseConverter;
import com.example.soldier.soldier.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController implements ICategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRequestConverter categoriaRequestConverter;

    @Autowired
    private CategoriaResponseConverter categoriaResponseConverter;


    @Override
    public ResponseEntity<?> cadastrarCategorias(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequestConverter.toEntity(categoriaRequest);
        categoriaService.cadastrar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<?> listarCategorias() {
        List<Categoria> categorialist = categoriaService.listar();
        return !categoriaResponseConverter.toResponse(categorialist).isEmpty() ? ResponseEntity.ok(categorialist) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> editarCategorias(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaService.buscarPorId(categoriaRequest.getId());
        categoria.setNome(categoriaRequest.getNome());
        categoriaRequestConverter.toEntity(categoriaRequest);
        categoriaService.editar(categoria);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @Override
    public void deletarCategoria(Long id) {
        categoriaService.deletar(id);
    }

    @Override
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(Long id) {
        Categoria iDCategoria = categoriaService.buscarPorId(id);
        return  ResponseEntity.ok(categoriaResponseConverter.toResponse(iDCategoria));
    }

}
