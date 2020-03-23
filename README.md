# Cadastro de Pessoas

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
> `http://localhost:8080/pessoas/bee63edf-d3e8-43d8-be2e-73beb3a8e8c6`

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
> `http://localhost:8080/pessoas/bee63edf-d3e8-43d8-be2e-73beb3a8e8c6`

> ### Headers
> `Authorization	Basic 42608df0-7e1b-4c97-8307-dee366762e74`
