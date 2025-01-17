
# API REST SpringBoot 

FORUMHUB Api feita em Java com SpringBoot


## Documentação da API

#### Registrar Usuario

```http
POST /register
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `String`     | **Obrigatório**: Seu email|
| `senha`      | `String`     | **Obrigatório**: Sua senha|


#### Logar

```http
POST /login
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `String`     | **Obrigatório**: Seu email|
| `senha`      | `String`     | **Obrigatório**: Sua senha|


#### Retorna todos os topicos

```http
  GET /topicos
```

#### Retorna um produto

```http
GET /topicos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long`     | **Obrigatório**: O ID do tópico que você quer |


#### Deleta um topico

```http
DELETE /topicos/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long`     | **Obrigatório**: O ID do tópico que você quer deletar|


#### Cadastrar novo tópico

```http
POST /topicos
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `titulo`      | `String`     | **Obrigatório**: Insira o titulo do tópico|
| `mensagem`      | `String`     | **Obrigatório**: Insira a mensagem do tópico|


