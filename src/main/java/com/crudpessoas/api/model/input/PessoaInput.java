package com.crudpessoas.api.model.input;

import com.crudpessoas.domain.model.Sexo.Sexo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaInput {

    @NotBlank
    private String nome;

    private Sexo sexo;

    @Email
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataNascimento;

    private String naturalidade;

    private String nacionalidade;

    @CPF
    private String cpf;

}
