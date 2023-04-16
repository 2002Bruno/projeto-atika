package com.example.soldier.soldier.enums;

public enum TipoLancamentoEnum {

    RECEITA("R","RECEITA"),

    DESPESA("D","DESPESA");

    private String codigo;

    private String descricao;

    TipoLancamentoEnum(String descricao, String codigo) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
