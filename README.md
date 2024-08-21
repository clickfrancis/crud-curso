**CRUD REST API Curso - EM DESENVOLVIMENTO**

**Descrição**


> Este projeto é uma API REST que permite cadastrar, consultar, atualizar e deletar alunos, curso e professor, além de vincular e desvicular aluno ao curso atráves da mátricula. O objetivo principal é testar e demonstrar os conhecimentos adquiridos em desenvolvimento de software, incluindo a utilização de várias tecnologias e práticas de desenvolvimento.

**Instalação**

Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em seu ambiente de desenvolvimento:

Java 17 ou superior
Maven 3.3.1 ou superior

**Passo a passo**
Clone o repositório para sua máquina local:

git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/clickfrancis/crud-curso.git)

Navegue até o diretório do projeto:
```cd repositorio-do-projeto```

Compile o projeto utilizando Maven:
```mvn clean install```

Execute o projeto:
```mvn spring-boot:run```

**Estrutura do Projeto**
O projeto está organizado no padrão MVC e as pastas principais:

> model: Contém as entidades do domínio.
infrastructure: Contém a configuração de infraestrutura, como repositórios e configurações do banco de dados.
Testes

> service: Contém a lógica de negócio.

> controller: Contém a as requisições de usuário input e outinput, sendo passadas os dtos de request e response.

O projeto será incluso testes unitários e de integração:

Testes unitários: Utilizando JUnit e Mockito.
Testes de integração: Utilizando MockMvc.

Para executar os testes, utilize o seguinte comando: (TESTE EM DESENVOLVIMENTO)
```mvn test```

Contribuição
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

Realizando um fork do projeto

Demais deverão ser feitas em uma nova branch para feature ou correção:

git checkout -b minha-feature
Commit suas alterações:

git commit -m 'Minha nova feature'
Envie para o repositório remoto:

git push origin minha-feature

Abra um Pull Request.

Endpoints Disponíveis
A API fornece os seguintes endpoints para gerenciar os dados meteorológicos:

```POST: /alunos```

```GET: /alunos```

```PUT: /alunos/{id}```

```DELETE: /alunos{id}```

Autor
**Francis Santos - Desenvolvedor**
