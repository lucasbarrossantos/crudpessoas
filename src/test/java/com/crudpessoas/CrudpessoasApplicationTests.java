package com.crudpessoas;

import com.crudpessoas.domain.model.Pessoa;
import com.crudpessoas.domain.model.Sexo.Sexo;
import com.crudpessoas.domain.service.CadastroPessoaService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest
class CrudpessoasApplicationTests {

	private final CadastroPessoaService cadastroPessoa;

	@Test
	void testarCadastroDePessoaComSucesso() {
		// Cenário
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João Ruan Arthur Fogaça");
		pessoa.setSexo(Sexo.MASCULINO);
		pessoa.setDataNascimento(LocalDate.of(1997, 2, 2));
		pessoa.setEmail("joaoruanarthurfogaca_@uol.com.br");
		pessoa.setCpf("649.862.084-62");
		pessoa.setNaturalidade("Brasileiro");
		pessoa.setNaturalidade("Macapá");

		// Ação
		pessoa = cadastroPessoa.adicionar(pessoa);

		// Validação
		assertThat(pessoa).isNotNull();
		assertThat(pessoa.getId()).isNotNull();
	}

}
