package com.crudpessoas.infrastructure.repository;

import com.crudpessoas.domain.model.Pessoa;
import com.crudpessoas.domain.repository.filter.PessoaFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PessoaSpecs {

    public static Specification<Pessoa> usandoFiltro(PessoaFilter filtro) {
        return (root, query, builder) -> {

            ArrayList<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotEmpty(filtro.getNome())) {
                predicates.add(builder.like(builder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
