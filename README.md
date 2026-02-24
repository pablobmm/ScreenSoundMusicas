# ScreenSound 🎵 - Catálogo Musical

O **ScreenSound** é uma aplicação Java robusta desenvolvida para gerenciar um catálogo completo de artistas e suas discografias. O projeto foi construído para consolidar conhecimentos em persistência de dados, consumo de APIs REST e boas práticas de Programação Orientada a Objetos.

## 🚀 Funcionalidades

* **Cadastro de Artistas**: Permite registrar o nome, nacionalidade e o tipo do artista (solo, dupla ou banda).
* **Gestão de Músicas**: Cadastro de faixas musicais associando-as diretamente a um artista cadastrado no banco.
* **Listagem e Busca**: Filtros para visualizar todas as músicas ou filtrar obras de um artista específico.
* **Integração com API Externa**: Realiza buscas automáticas na API **TheAudioDB** para obter biografias, gênero musical e ano de fundação dos artistas.

## 🛠️ Tecnologias Utilizadas

* **Java 21**: Utilização de **Records** para mapeamento de dados e novas funcionalidades da linguagem.
* **Spring Boot 3**: Framework para gerenciamento de dependências e injeção de controle.
* **Spring Data JPA**: Abstração da camada de persistência para facilitar operações de CRUD.
* **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados do catálogo.
* **Jackson**: Biblioteca para desserialização de JSONs complexos retornados pela API.
* **HttpClient**: Ferramenta nativa do Java para consumo de serviços REST.



## 📂 Estrutura de Pacotes

* `model`: Entidades JPA e Records de DTO.
* `repository`: Interfaces de persistência (Spring Data).
* `service`: Lógica de consumo de API e tratamento de dados.
* `principal`: Interface de linha de comando (CLI) e menu interativo.

## 🔧 Configuração

Para rodar o projeto localmente:

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/ScreenSoundMusicas.git](https://github.com/seu-usuario/ScreenSoundMusicas.git)
2. Configure o banco de dados
    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
3. Execute a aplicação via IntelliJ ou Maven:
    ```bash
      mvn spring-boot:run
