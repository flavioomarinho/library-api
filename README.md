![capa](https://user-images.githubusercontent.com/18190240/165532541-78b32a68-6c0d-4e5d-901c-3d362abed047.png)

## Índice 

* [Índice](#índice)
* [Descrição do Projeto](#descrição-do-projeto)
* [Status do Projeto](#status-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Abrir e Rodar o Projeto](#abrir-e-rodar-o-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras do Projeto](#pessoa-desenvolvedora)

## Descrição do Projeto

- `API REST desenvolvida para gestão de uma biblioteca.`

## Status do Projeto

- `Projeto Concluído`

## Funcionalidades
- `Funcionalidade 1` `Cadastro de Usuários`: O sistema permite cadastrar os usuários que irão utilizar o serviço de empréstimo de livros da biblioteca. Para cadastrar um usuário, devem ser informados seu nome, seu telefone, seu cpf e seu endereço. Todos os campos são obrigatórios. Além de cadastrar, o sistema permite a realização da alteração, exclusão e consulta dos usuários cadastrados.


```
Método POST (Cadastra)
localhost:8080/users
Corpo da requisição
{
    "name":"Elisa",
    "phone":"048991345284",
    "cpf":"06158973425",
    "address":"Laguna",
    "availability":0
}

Método PUT (Altera informação)
localhost:8080/users/1
Corpo da requisição
{
    "name":"Elisa Marinho",
    "phone":"048991345284",
    "cpf":"06158973425",
    "address":"Laguna",
    "availability":0
}

Método GET (Consulta todos os livros)
localhost:8080/users

Método DELETE (Deleta registro)
localhost:8080/books/1
```

- `Funcionalidade 2` `Cadastro de Livros`: O sistema permite cadastrar os livros que farão parte do acervo da biblioteca. Para cadastrar um livro, devem ser informados seu título, seu autor, seu gênero e o assunto que se trata o livro. Todos os campos são obrigatórios. Além de cadastrar, o sistema permite a realização da alteração, exclusão e consulta dos livros cadastrados.

```
Método POST (Cadastra)
localhost:8080/books
Corpo da requisição
{
    "title":"Pocoyo e a Floresta",
    "gender":"infantil",
    "author":"Pocoyo",
    "subject":"cuidados com o meio ambiente",
    "availability":0
}

Método PUT (Altera informação)
localhost:8080/books/8
Corpo da requisição
{
    "title":"Pocoyo e a Floresta Amarela",
    "gender":"infantil",
    "author":"Pocoyo",
    "subject":"cuidados com o meio ambiente",
    "availability":0
}

Método GET (Consulta todos os livros)
localhost:8080/books

Método DELETE (Deleta registro)
localhost:8080/books/8
```

- `Funcionalidade 3` `Empréstimo de Livros`: O sistema realiza a operação de empréstimo de livros para os usuários, limitado a quantidade de empréstimo a dois livros por usuário. Para realizar um empréstimo deve ser informado o código de identificação do usuário e o código de identificação dos livros, podendo ser emprestados um ou dois livros por operação.

```
Método POST (Empréstimo)
localhost:8080/loan
Corpo da requisição
{
    "user":1,
    "itens":[
        {
       "book":8
    }
    ]
}
 ```
 
- `Funcionalidade 4` `Devolução de Livros`: O sistema realiza a operação de devolução dos livros emprestados aos usuários. Para realização da devolução deve ser informado o código de identificação do usuário e do livro, podendo ser devolvido apenas um livro por operação.

```
Método POST (Devolução)
localhost:8080/devolution
Corpo da requisição
{
    "user":1,
    "book":8
}
```

- `Funcionalidade 5` `Consultas`: O sistema permite realizar a consulta das informação de um usuário pelo seu nome.

```
Método GET (Consulta livro por autor)
localhost:8080/users/name?name=Elisa
```

- `Funcionalidade 6` `Consultas`: O sistema permite realizar a consulta das informação de um livro pelo seu título ou pelo autor.

```
Método GET (Consulta livro por autor)
localhost:8080/books/author?author=Pocoyo

Método GET (Consulta livro por título)
localhost:8080/books/title?title=Pocoyo e a Floresta
```

## Abrir e rodar o projeto

- `Após baixar o projeto, você pode abri-lo com o InteliJ IDEA.`
- `Em paralelo você deve configurar uma instância do banco de dados MYSQL utilizando a ferramenta MYSQL Workbench.`
- `Uma vez configurado o banco de dados, você deve rodar o seguinte script:
CREATE DATABASE library`
- `Na pasta resources do projeto você encontrará o arquivo application.properties ao qual você deve alterá-lo conforme a sua instância do banco de dados, essas informações você pode conferir no MYSQL Workbench`.

```
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=root
```

- `Após a configuração da conexão com o banco de dados, você deve clicar com o botão direito encima do projeto, ir na guia Maven e clicar em Reload project. Essa ação vai fazer com que o Maven baixe todas as dependências necessárias para execução do projeto`
- `Feito isso é só executar o projeto!`

## Tecnologias utilizadas
- `Java 11`
- `Maven`
- `Hibernate JPA`
- `Spring Boot`
- `Lombok`
- `MySQL`
- `InteliJ IDEA`
- `JSON`

## Pessoa Desenvolvedora

[<img src="https://avatars.githubusercontent.com/u/18190240?v=4" width=115><br><sub>Flávio da Rosa Marinho</sub>](https://github.com/flavioomarinho)] 




