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

- `Funcionalidade 2` `Cadastro de Livros`: O sistema permite cadastrar os livros que farão parte do acervo da biblioteca. Para cadastrar um livro, devem ser informados seu título, seu autor, seu gênero e o assunto que se trata o livro. Todos os campos são obrigatórios. Além de cadastrar, o sistema permite a realização da alteração, exclusão e consulta dos livros cadastrados.

- `Funcionalidade 3` `Empréstimo de Livros`: O sistema realiza a operação de empréstimo de livros para os usuários, limitado a quantidade de empréstimo a dois livros por usuário. Para realizar um empréstimo deve ser informado o código de identificação do usuário e o código de identificação dos livros, podendo ser emprestados um ou dois livros por operação.
 
- `Funcionalidade 4` `Devolução de Livros`: O sistema realiza a operação de devolução dos livros emprestados aos usuários. Para realização da devolução deve ser informado o código de identificação do usuário e do livro, podendo ser devolvido apenas um livro por operação.

- `Funcionalidade 5` `Consultas`: O sistema permite realizar a consulta das informação de um usuário pelo seu nome.

- `Funcionalidade 6` `Consultas`: O sistema permite realizar a consulta das informação de um livro pelo seu título ou pelo autor.

## Abrir e rodar o projeto

- `Após baixar o projeto, você pode abri-lo com o InteliJ IDEA.`

- `Antes de executar o projeto você deve configurar o seu banco de dados MYSQL através do MYSQL Workbench utilizando as informações contidas no arquivo properties do projeto.`

- `Uma vez configurado o banco de dados, você deve rodar o seguinte script:
CREATE DATABASE library`

- `Criado o banco de dados você deve executar o Maven para baixar todas as bibliotecas e depenências que o projeto necessita.`

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




