package com.example.soldier.soldier.enums;

public enum StatusEnum {

    ATIVO("ATIVO","ATIVO"),

    INATIVO("ATIVO","INATIVO");

    private String codigo;
    private String descricao;

    StatusEnum(String descricao, String codigo) {
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
