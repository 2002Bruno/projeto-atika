package com.example.soldier.soldier.controller;

import com.example.soldier.soldier.controller.IController.IPessoaController;
import com.example.soldier.soldier.dto.request.PessoaRequest;
import com.example.soldier.soldier.dto.request.PessoaRequestConverter;
import com.example.soldier.soldier.dto.response.PessoaResponse;
import com.example.soldier.soldier.dto.response.PessoaResponseConverter;
import com.example.soldier.soldier.entity.pessoa.Pessoa;
import com.example.soldier.soldier.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController implements IPessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRequestConverter pessoaRequestConverter;

    @Autowired
    private PessoaResponseConverter categoriaResponseConverter;


    @Override
    public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
        Pessoa categoria = pessoaRequestConverter.toEntity(pessoaRequest);
        pessoaService.cadastrar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<?> listarPessoas() {
        List<Pessoa> categorialist = pessoaService.listar();
        return !categoriaResponseConverter.toResponse(categorialist).isEmpty() ? ResponseEntity.ok(categorialist) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> editarPessoa(PessoaRequest pessoaRequest) {
        Pessoa categoria = pessoaService.buscarPorId(pessoaRequest.getId());
        categoria.setNome(pessoaRequest.getNome());
        categoria.setEndereco(pessoaRequest.getEndereco());
        pessoaRequestConverter.toEntity(pessoaRequest);
        pessoaService.editar(categoria);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @Override
    public void deletarPessoa(Long id) {
        pessoaService.deletar(id);
    }

    @Override
    public ResponseEntity<PessoaResponse> buscarPessoaPorId(Long id) {
        Pessoa iDPessoa = pessoaService.buscarPorId(id);
        return  ResponseEntity.ok(categoriaResponseConverter.toResponse(iDPessoa));
    }

}
