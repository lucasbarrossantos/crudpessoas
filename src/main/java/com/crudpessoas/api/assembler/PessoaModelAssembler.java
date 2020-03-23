package com.crudpessoas.api.assembler;

import com.crudpessoas.api.model.input.PessoaInput;
import com.crudpessoas.api.model.input.PessoaModel;
import com.crudpessoas.domain.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaModelAssembler {

    private final ModelMapper modelMapper;

    public Pessoa toDomainObject(PessoaInput pessoaInput) {
        return modelMapper.map(pessoaInput, Pessoa.class);
    }

    public PessoaModel toModel(Pessoa pessoa) {
        return modelMapper.map(pessoa, PessoaModel.class);
    }

    public void copyToDomainObject(PessoaInput pessoaInput, Pessoa pessoa) {
        modelMapper.map(pessoaInput, pessoa);
    }

    public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
