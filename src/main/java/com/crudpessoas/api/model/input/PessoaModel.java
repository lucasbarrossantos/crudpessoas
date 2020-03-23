package com.crudpessoas.api.model.input;

import com.crudpessoas.domain.model.Sexo.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PessoaModel {

    private UUID codigo;
    private String nome;
    private Sexo sexo;
    private String email;
    private LocalDate dataNascimento;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;

}
