# LiterAlura - Catálogo de livros em banco de dados via GutendexAPI

<div align="center">
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

</div>

## Índice
=================
<!--ts-->
* [Título](#literalura---catálogo-de-em-banco-de-dados-via-gutendexapi)
* [Índice](#índice)
* [Proposta do projeto](#proposta-do-projeto)
* [Tecnologias](#tecnologias)
* [Status do projeto](#status-do-projeto)
* [Sobre o projeto](#sobre-o-projeto)
  * [Classe de exibição](#classe-de-exibição)
  * [Classes de serviço](#classes-de-serviço)
  * [Classes de entidade](#classes-de-entidade)
  * [Classes de repository](#classes-de-repository)
  * [Demonstração do projeto](#demonstração-do-projeto)
    * [Adicionando livros](#adicionando-livros)
    * [Listando livros e autores](#listando-livros-e-autores)
    * [Listando autores vivos em uma determinada data](#listando-autores-vivos-em-uma-determinada-data)
    * [Listando livros de apenas um idioma especifico](#listando-livros-de-apenas-um-idioma-especifico)
    
* [Agradecimentos](#agradecimentos)
* [Autor](#autor)
<!--te-->


## Proposta do projeto
Desafio da formação AluraOne, da plataforma [Alura](https://www.alura.com.br).<br>
OBJETIVO: Desenvolver um Catálogo de Livros que ofereça interação textual (via console) com os usuários, proporcionando no mínimo 5 opções de interação.
Os livros serão buscados através de uma API específica, a [Gutendex](https://gutendex.com).<br>

Métodos necessários:

1 - Buscar o livro pelo título

2 - Listar livros registrados

3 - Listar autores registrados

4 - Listar autores vivos em um determinado ano

5 - Listar livros em um determinado idioma

# Status do projeto
✅Concluido✅

# Sobre o projeto
### Classe de configuração

Dentro do pacote `br.com.alura.literAlura.resources` no arquivo `application.properties`, foi utilizado de variaveis de ambiente para o host (`localhost`), username e senha do banco de dados<br>
Portanto caso queira rodar o projeto será necessário criar estas variaveis de ambiente

<div align="center">
  
![image](https://github.com/user-attachments/assets/1abed47a-2bdc-42f0-b02b-ecf231e29649)

</div>

### Classe de exibição

No pacote `br.com.alura.literAlura` a classe `LiterAluraAplication` é necessária para rodar o projeto e se tratando de uma aplicação no terminal ela implementa a interface `CommandLineRunner`

<div align="center">
  
![image](https://github.com/user-attachments/assets/80286e0a-cf22-40fb-ba92-1fabf46e82f5)

</div>

Ela vai instanciar a classe `br.com.alura.literAlura.view.Principal` e chamar o método `exibirMenu()` atráves desse método todos os métodos do desafio podem ser executados<br>

<div align="center">
  
![image](https://github.com/user-attachments/assets/f2c373b2-95b6-4102-b0c1-109ea15d4697)

</div>

### Classes de serviço
As classes `br.com.alura.literAlura.service.ConsumoApi`, `br.com.alura.literAlura.model.Resultado` ,`br.com.alura.literAlura.model.DadosAutor` e `br.com.alura.literAlura.model.DadosLivro` são utilizadas para:
- ConsumoApi: Consumo da API [Gutendex](https://gutendex.com)
- Resultado: Intermediaria para conversão do JSON para as classes DadosAutor e DadosLivro, através de anotações e métodos da biblioteca Jackson
- DadosAutor e DadosLivro: recebem os dados para a criação das classes entidade Autor e Livro 

### Classes de entidade
As classes `br.com.alura.literAlura.model.Autor` e `br.com.alura.literAlura.model.Livro` representam as tabelas que serão usadas no banco de dados, através de anotações da biblioteca Spring Data JPA

### Classes de repository
As interfaces `br.com.alura.literAlura.repository.AutorRepository` e `br.com.alura.literAlura.repository.LivroRepository` herdam da interface `JpaRepository` posibilitando o uso de derived queries para mainupulação do banco de dados <br>
Elas vão ser atributos da classe `br.com.alura.literAlura.view.Principal` pois necessitam que a classe `br.com.alura.literAlura.LiterAluraAplication` utilize a anotação `@AutoWired` para deixar claro que o `SpringBoot` vai gerenciar elas

### Demonstração do projeto

#### Adicionando livros
Utilizando o primeiro método para adicionar ao banco de dados o livro "Dom Casmurro" do autor "Machado de Assis"

<div align="center">
  
![image](https://github.com/user-attachments/assets/c42cced2-7ef8-485e-9279-a0f623927209)

![image](https://github.com/user-attachments/assets/59707a92-3ffe-4e44-8a85-e3b10c8695b7)


</div>

Novamente com o primeiro método para adicionar o livro "The Great Gatsby(O grande Gatsby) " do autor "F. Scott Fitzgerald"

<div align="center">
  
![image](https://github.com/user-attachments/assets/73038ed0-483d-4f82-bd33-7c4d8bfc67ca)

![image](https://github.com/user-attachments/assets/ca990248-0854-4e5b-8699-67641efc5d02)

</div>

#### Listando livros e autores
Agora escolhendo o segundo método, para listar os livros registrados

<div align="center">
  
  ![image](https://github.com/user-attachments/assets/71cab84b-ae20-4986-8264-628e74011719)
  
</div>

Com o terceiro método, para listar os autores registrados

<div align="center">
  
  ![image](https://github.com/user-attachments/assets/789c46e5-d396-41c5-b7fd-ce6916e18009)

</div>

#### Listando autores vivos em uma determinada data

Usando o quarto método e escolhendo um ano limite para mostrar apenas dentre os autores registrados, quais estavam vivos naquele ano<br>
a exemplo dentre os dois autores registrados, quais estavam vivos em 1910?

<div align="center">
  
![image](https://github.com/user-attachments/assets/f1625df0-2dc4-4823-92aa-b8936c03b7a9)

</div>

#### Listando livros de apenas um idioma especifico
Por fim o quinto método, supondo que eu queira ver apenas os livros em português, vou adicionar mais um livro brasileiro antes

<div align="center">
  
![image](https://github.com/user-attachments/assets/61107fa3-9ade-4e18-863a-b80d9a1451ba)

![image](https://github.com/user-attachments/assets/bb4fd334-1abf-4b04-a445-56e9602bb155)

</div>

# Tecnologias
- Linguagem
  - [Java](https://www.oracle.com/br/java/) 
- FrameWork e bibliotecas:
  - [SpringBoot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
  - [PostgreSQL Driver](https://jdbc.postgresql.org)

- Banco de dados
  - [PostGreSQL](https://www.postgresql.org)

- API
  - [Gutendex](https://gutendex.com)

- Gerenciador de dependencias
  - [Maven](https://maven.apache.org)

## Agradecimentos
Agradeço a Alura e todos os professores da formação por todo o aprendizado passado e desafios propostos.

## Autor

<div align="center">
<a href="https://www.linkedin.com/in/thiago-antenor/">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/99970279?v=4" width="100px;" alt="foto do autor"/>
 <br />
 <sub><b>Thiago Silva Antenor</b></sub></a> <a href="https://www.linkedin.com/in/thiago-antenor/" title="Linkedin"> 🧑🏾‍💻</a>


Feito por Thiago Silva Antenor 👨🏾‍💻 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/thiago-antenor/)](https://www.linkedin.com/in/thiago-antenor/) 
[![Gmail Badge](https://img.shields.io/badge/-thiagoantenor31@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:thiagoantenor31.com)](mailto:thiagoantenor31.com)
</div>
