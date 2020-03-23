# API Cadastro de Pessoas

## Start

Após clonar este repositório e importar na sua IDE de preferência, então o maven irá baixar as dependências do projeto. Após isso é só rodar ou pelo maven ou pela ide

Pelo maven: `./mvnw spring-boot:run`

Setup
- Java 8
- Project Lombok [v:1.18.12](https://projectlombok.org/) 
- Spring Boot
- Spring Data JPA
- Postgresql
- Hibernate
- Junit para testes
- Spring Security. Autenticação `Basic`
- Modelmapper


> Guia de configuração do [Lombok](https://dicasdejava.com.br/como-configurar-o-lombok-no-eclipse/)

#### Importante! Ao rodar o projeto no ambiente local, é importamte mudar no application.properties o tipo de ambiente para dev, pois se deixar como prod, não vai funcionar a conexão com o Heroku por conta de limitação do plano free.

> ## ![#f03c15](https://placehold.it/15/fdff49/000000?text=+) POST Adicionar
> `http://localhost:8080/api/pessoas`

> ### Body

```json
{
	"nome": "Lucas Barros Santos", 
	"sexo": "MASCULINO",
	"email": "lucas-barros28@hotmail.com@hotmail.com", 
	"dataNascimento": "1992-08-14",
	"naturalidade": "Recife", 
	"nacionalidade": "Brasileiro", 
	"cpf": "xxx.xxx.xxx-xx"
}
```
> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`

----

> ## ![#1589F0](https://placehold.it/15/3dd200/000000?text=+) GET Listar
> `http://localhost:8080/api/pessoas`

> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`

----

> ## ![#1589F0](https://placehold.it/15/3dd200/000000?text=+) GET Pesquisar por Id
> `http://localhost:8080/api/pessoas/bee63edf-d3e8-43d8-be2e-73beb3a8e8c6`

> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`

----

> ## ![#1589F0](https://placehold.it/15/3dd200/000000?text=+) GET Pesquisar por Nome
> `http://localhost:8080/api/pessoas?nome=Lucas`

> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`

----

> ## ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) PUT Atualizar
> `http://localhost:8080/api/pessoas/bee63edf-d3e8-43d8-be2e-73beb3a8e8c6`

> ### Body

```json
{
	"nome": "Lucas Barros Santos", 
	"sexo": "MASCULINO",
	"email": "lucas-barros28@hotmail.com@hotmail.com", 
	"dataNascimento": "1992-08-14",
	"naturalidade": "Recife", 
	"nacionalidade": "Brasileiro", 
	"cpf": "xxx.xxx.xxx-xx"
}
```
> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`

----

> ## ![#1589F0](https://placehold.it/15/ff0000/000000?text=+) DELETE Pessoa
> `http://localhost:8080/api/pessoas/bee63edf-d3e8-43d8-be2e-73beb3a8e8c6`

> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`
