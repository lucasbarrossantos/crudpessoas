package com.crudpessoas.api.controller;

import com.crudpessoas.api.assembler.PessoaModelAssembler;
import com.crudpessoas.api.model.input.PessoaInput;
import com.crudpessoas.api.model.input.PessoaModel;
import com.crudpessoas.domain.model.Pessoa;
import com.crudpessoas.domain.repository.PessoaRepository;
import com.crudpessoas.domain.repository.filter.PessoaFilter;
import com.crudpessoas.domain.service.CadastroPessoaService;
import com.crudpessoas.infrastructure.repository.PessoaSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private final PessoaModelAssembler pessoaModelAssembler;
    private final CadastroPessoaService cadastroPessoa;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaController(PessoaModelAssembler pessoaModelAssembler,
                            CadastroPessoaService cadastroPessoa,
                            PessoaRepository pessoaRepository) {
        this.pessoaModelAssembler = pessoaModelAssembler;
        this.cadastroPessoa = cadastroPessoa;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public Page<PessoaModel> listar(Pageable pageable, PessoaFilter filter) {
        Page<Pessoa> pessoasPage = pessoaRepository.findAll(PessoaSpecs.usandoFiltro(filter), pageable);
        List<PessoaModel> pessoasModel = pessoaModelAssembler.toCollectionModel(pessoasPage.getContent());
        return new PageImpl<>(pessoasModel, pageable, pessoasPage.getTotalElements());
    }

    @GetMapping("/{pessoaId}")
    public PessoaModel buscar(@PathVariable UUID pessoaId) {
        Pessoa pessoa = cadastroPessoa.buscarOuFalhar(pessoaId);
        return pessoaModelAssembler.toModel(pessoa);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel adicionar(@RequestBody @Valid PessoaInput pessoaInput) {
        Pessoa pessoa = pessoaModelAssembler.toDomainObject(pessoaInput);
        pessoa = cadastroPessoa.adicionar(pessoa);
        return pessoaModelAssembler.toModel(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public PessoaModel atualizar(@PathVariable UUID pessoaId, @RequestBody @Valid PessoaInput pessoaInput) {
        Pessoa pessoaDB = cadastroPessoa.buscarOuFalhar(pessoaId);
        pessoaModelAssembler.copyToDomainObject(pessoaInput, pessoaDB);
        pessoaDB = cadastroPessoa.adicionar(pessoaDB);
        return pessoaModelAssembler.toModel(pessoaDB);
    }

    @DeleteMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable UUID pessoaId) {
        cadastroPessoa.excluir(pessoaId);
    }

}
