package com.crudpessoas.domain.model;

import com.crudpessoas.domain.model.Sexo.Sexo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pessoa {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID codigo;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String email;

    private LocalDate dataNascimento;

    private String naturalidade;

    private String nacionalidade;

    @Column(nullable = false, unique = true)
    private String cpf;

    @CreationTimestamp
    private OffsetDateTime dataCriacao;

    @UpdateTimestamp
    private OffsetDateTime dataAtualizacao;

    @PrePersist
    private void gerarCodigo() {
        setCodigo(UUID.randomUUID());
    }

}
