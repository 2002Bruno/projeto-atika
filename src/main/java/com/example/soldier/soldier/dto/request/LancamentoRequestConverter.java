package com.example.soldier.soldier.dto.request;

import com.example.soldier.soldier.entity.Lancamento;
import com.example.soldier.soldier.modelmapper.AbstractEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class LancamentoRequestConverter extends AbstractEntityMapper<LancamentoRequest, Lancamento> {
    @Override
    public Lancamento toEntity(LancamentoRequest request) {
        return Lancamento.builder()
                .id(request.getId())
                .descricao(request.getDescricao())
                .dataVencimento(request.getDataVencimento())
                .dataPagamento(request.getDataPagamento())
                .valor(request.getValor())
                .observacao(request.getObservacao())
                .build();
    }
}
