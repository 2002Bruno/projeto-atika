package com.example.soldier.soldier.enums;

public enum StatusEnum {

    ATIVO("ATIVO"),

    INATIVO("INATIVO");

    private String descricao;

    StatusEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
