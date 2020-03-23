package com.crudpessoas.domain.model.Sexo;

import lombok.Getter;

@Getter
public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

}
