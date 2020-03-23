package com.crudpessoas.domain.service;

import com.crudpessoas.domain.exception.NegocioException;
import com.crudpessoas.domain.exception.PessoaNaoEncontradaException;
import com.crudpessoas.domain.model.Pessoa;
import com.crudpessoas.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CadastroPessoaService {

    private final PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa adicionar(Pessoa pessoa) {

        try {

            pessoa = pessoaRepository.save(pessoa);
        } catch (DataIntegrityViolationException e) {
            throw new NegocioException("O CPF informado já está cadastrado no sistema.", e);
        }

        return pessoa;
    }

    public Pessoa buscarOuFalhar(UUID pessoaId) {
        return pessoaRepository.findByCodigo(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId.toString()));
    }

    @Transactional
    public void excluir(UUID pessoaId) {
        try {
            Pessoa pessoa = buscarOuFalhar(pessoaId);
            pessoaRepository.deleteById(pessoa.getId());
            pessoaRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new PessoaNaoEncontradaException(pessoaId.toString());
        }
    }
}
