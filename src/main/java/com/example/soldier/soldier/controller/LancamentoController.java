package com.example.soldier.soldier.controller;

import com.example.soldier.soldier.controller.IController.ILancamentoController;
import com.example.soldier.soldier.dto.request.LancamentoRequest;
import com.example.soldier.soldier.dto.request.LancamentoRequestConverter;
import com.example.soldier.soldier.dto.response.LancamentoResponse;
import com.example.soldier.soldier.dto.response.LancamentoResponseConverter;
import com.example.soldier.soldier.entity.Lancamento;
import com.example.soldier.soldier.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/lancamentos")
public class LancamentoController implements ILancamentoController {

    @Autowired
    private LancamentoService pessoaService;

    @Autowired
    private LancamentoRequestConverter lancamentoRequestConverter;

    @Autowired
    private LancamentoResponseConverter lancamentoResponseConverter;


    @Override
    public ResponseEntity<?> cadastrarLancamento(@Valid @RequestBody LancamentoRequest lancamentoRequest) {
        Lancamento lancamento = lancamentoRequestConverter.toEntity(lancamentoRequest);
        pessoaService.cadastrar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<?> listarLancamentos() {
        List<Lancamento> lancamentoList = pessoaService.listar();
        return !lancamentoResponseConverter.toResponse(lancamentoList).isEmpty() ? ResponseEntity.ok(lancamentoList) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @Override
    public ResponseEntity<?> editarLancamento(LancamentoRequest lancamentoRequest) {
        Lancamento lancamento = pessoaService.buscarPorId(lancamentoRequest.getId());
        lancamento.setDescricao(lancamentoRequest.getDescricao());
        lancamento.setDataPagamento(lancamentoRequest.getDataPagamento());
        lancamento.setDataVencimento(lancamentoRequest.getDataVencimento());
        lancamento.setObservacao(lancamentoRequest.getObservacao());
        lancamento.setValor(lancamentoRequest.getValor());
        lancamentoRequestConverter.toEntity(lancamentoRequest);
        pessoaService.editar(lancamento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @Override
    public void deletarLancamento(Long id) {
        pessoaService.deletar(id);
    }

    @Override
    public ResponseEntity<LancamentoResponse> buscarLancamentoPorId(Long id) {
        Lancamento iDLancamento = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(lancamentoResponseConverter.toResponse(iDLancamento));
    }

}
