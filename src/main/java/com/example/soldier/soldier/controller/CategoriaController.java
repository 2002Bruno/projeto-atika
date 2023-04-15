package com.example.soldier.soldier.controller;

import com.example.soldier.soldier.controller.IController.ICategoriaController;
import com.example.soldier.soldier.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.soldier.soldier.request.CategoriaRequest;
import com.example.soldier.soldier.request.CategoriaRequestConverter;
import com.example.soldier.soldier.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController implements ICategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRequestConverter categoriaRequestConverter;


    @Override
    public ResponseEntity cadastrar(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequestConverter.toEntity(categoriaRequest);
        categoriaService.cadastrar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /*@Override
    public ResponseEntity editar(PessoaRequest pessoaRequest) {
        Pessoa pessoa = pessoaService.buscarPorId(pessoaRequest.getId());
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setEmail(pessoaRequest.getEmail());
        pessoaService.editar(pessoa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<PessoaResponse>> listar() {
        return ResponseEntity.ok(pessoaResponseConverter.toResponse(pessoaService.listaPadrao()));

    }

    @Override
    public void deletar(Long id) {
        pessoaService.excluirLogicamente(id);
    }

    @Override
    public ResponseEntity<PessoaResponse> findById(Long id) {
        return ResponseEntity.ok(pessoaResponseConverter.toResponse(pessoaService.buscarPorId(id)));
    }

    @Override
    public ResponseEntity<List<PessoaResponse>> listarTodos() {
        return ResponseEntity.ok(pessoaResponseConverter.toResponse(pessoaService.listarTodos()));
    }

    @Override
    public ResponseEntity<List<PessoaResponse>> listarTecnicos() {
        return ResponseEntity.ok(pessoaResponseConverter.toResponse(pessoaService.listarTecnicos()));
    }*/

}
