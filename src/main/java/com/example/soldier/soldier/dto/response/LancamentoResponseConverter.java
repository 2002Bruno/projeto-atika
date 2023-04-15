package com.example.soldier.soldier.dto.response;

import com.example.soldier.soldier.entity.Lancamento;
import com.example.soldier.soldier.modelmapper.AbstractResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class LancamentoResponseConverter extends AbstractResponseMapper<Lancamento, LancamentoResponse> {

    @Override
    public LancamentoResponse toResponse(Lancamento response) {
        return LancamentoResponse.builder()
                .id(response.getId())
                .descricao(response.getDescricao())
                .dataVencimento(response.getDataVencimento())
                .dataPagamento(response.getDataPagamento())
                .valor(response.getValor())
                .observacao(response.getObservacao()).build();
    }
}
