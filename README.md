# Sistema de Gestão de Clientes

## Descrição

Este projeto é um Sistema de Gestão de Clientes, desenvolvido com o objetivo de permitir cadastro de clientes, atualização e exclusão. A aplicação utiliza o Spring Framework e Java para o Back End, usando uma estrutura RESTful e suporte basico para autenticação via JWT.
Tudo isso dentro de um Deploy feito no Render.com usando plano gratuito por enquanto.

## Oque falta ser feito:

- Front End para a aplicação
- Organizar a velocidade de busca do Deploy.
- Melhorar a autenticação do SpringSecurity adicionando uma tabela de Usuarios para melhorar salvar usuarios e permitir a alteração se senhas.
- Incluir aba Financeiro para que seja cadastrado junto ao cliente a forma de pagamento e valor, e assim seja possível gerar um Relatório PDF filtrando por datas.


## Tecnologias Usadas:

- **Java**: Versão 17
- **Spring Boot**
- **Spring Security**: Para autenticação e autorização
- **Spring Data JPA**: Para interação com o Banco de Dados
- **Docker**: Para Conteinerização do projeto
- **Render**: Para o Deploy da aplicação
- **Swagger**: Para documentação da API
- **SonarQube** e **Jakoku**: Para defiinir métricas de qualidade, como quantidade de bugs, códigos duplicados, e verificar a segurança das dependencias. E uso do Jakoku para verificar cobertura de testes, medir eficiencias dos testes e definir um minimo de cobertura esperado.
- **Actuator**: Para disponibilizar as rotas e assim visializar as métricas e informações da aplicação
- **Grafana** e **Prometheus**: Para monitoramento dos serviços, usando o Prometheus para atuar junto ao BackEnd gerando as métricas das aplicações e o Grafana para gerar os gráficos com as informações em tempo real

## Imagens

Grafana e Prometheus(DataSource)

![GrafanaPrint](https://github.com/user-attachments/assets/8d883815-a475-4966-9013-7276af9d9dde)


##

SonarQube e Jakoku

![SonarQubePrint](https://github.com/user-attachments/assets/318f0744-5ec9-4bef-983b-dba4db1df8fe)

## Pré-requisitos

 - Java 17
 - Maven
 - IDE de sua escolha (IntelliJ, Eclipse, etc.)
 - Banco de Dados PostgreSQL
 - Docker instalado na sua máquina

## Instalação

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/zKaminise/Controle-de-Cliente-Psicologia-.git
   cd Controle-de-Cliente-Psicologia-
   ```

2. **Configuração e execução com Docker:**

   - Com o Docker e Docker Compose instalados, execute o ambiente completo (banco de dados e aplicação) com o comando:

     ```bash
     docker-compose up -d
     ```
   - **Estou finalizando toda configuração de Docker para funcionamento 100%**

3. **Acesso a aplicação**

   - A aplicação estará disponivel em:
     ```
     http://localhost:8080
     ```
   - O Grafana estará disponivel em:
     ```
     http://localhost:3000
     ```
   - O SonarQube estará disponivel em:
  
   - Necessário rodar o seguinte comando no terminal do Projeto:
     ```
     mvn clean verify sonar:sonar
     ```
    - E então acessar: 
       ```
       http://localhost:9000
       ```

### Endpoints Principais

- **Autenticação**
    - `POST /login`: Login com usuario e senha
    - `PUT /passowrd/reset`: Reset de senha
      
- **Clientes**
    - `GET /clientes`: Listar todos clientes
    - `GET /clientes/{cpf}`: Listar Cliente por CPF
    - `POST /clientes`: Cadastrar Novo Cliente
    - `PUT /clientes/{id}`: Alterar informações do Cliente
    - `DELETE /clientes/{id}`: Excluir cliente da base de dados

## Documentação

A documentação da API está disponivel através do Swagger no URL:

```
http://localhost:8080/swagger-ui/index.html
```

## Autor

**Gabriel Misao Pinheiro Kaminise**

https://linkedin.com/in/gabrielkaminise

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
