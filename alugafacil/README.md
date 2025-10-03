# Aluga Fácil - Sistema de Gestão de Aluguéis

## 📋 Visão Geral
O Aluga Fácil é um sistema de gestão de aluguéis de imóveis que permite o cadastro de imóveis, inquilinos e o controle de pagamentos de aluguéis. O sistema foi desenvolvido com Java e Spring Boot, seguindo as melhores práticas de desenvolvimento de software.

## 🚀 Funcionalidades

### 📌 Módulo de Imóveis
- Cadastro de imóveis com descrição e endereço
- Atualização de informações do imóvel
- Listagem de todos os imóveis cadastrados

### 👥 Módulo de Inquilinos
- Cadastro de inquilinos com dados pessoais
- Vinculação de inquilinos a imóveis
- Histórico de aluguéis por inquilino

### 💰 Módulo de Aluguéis
- Registro de contratos de aluguel
- Controle de pagamentos
- Relatório de aluguéis em atraso
- Gerenciamento de vencimentos

## 🛠️ Tecnologias Utilizadas

### Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (para desenvolvimento)
- Maven (gerenciamento de dependências)
- ModelMapper (mapeamento de objetos)
- Bean Validation (validação de dados)
- SpringDoc OpenAPI (documentação da API)

### Testes
- JUnit 5
- Mockito
- MockMvc
- Hamcrest

## 📚 Documentação da API

A API segue o padrão RESTful e está documentada com OpenAPI (Swagger). Após iniciar a aplicação, acesse:

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

### Endpoints Principais

#### Imóveis
- `POST /imoveis` - Cadastra um novo imóvel

#### Inquilinos
- `POST /inquilinos` - Cadastra um novo inquilino

#### Aluguéis
- `POST /alugueis` - Registra um novo aluguel
- `PATCH /alugueis/{id}/pagar` - Registra o pagamento de um aluguel
- `GET /alugueis/atrasados` - Lista os aluguéis em atraso

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8 ou superior
- Git (opcional, para clonar o repositório)

### Passo a Passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/aluga-facil.git
   cd aluga-facil/alugafacil
   ```

2. **Instale as dependências**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a aplicação**
   - API: http://localhost:8080
   - Console H2: http://localhost:8080/h2-console
     - JDBC URL: jdbc:h2:mem:alugafacil
     - User Name: sa
     - Password: (deixe em branco)

## 🧪 Executando os Testes

Para executar todos os testes do projeto:

```bash
mvn test
```

Para executar testes específicos:

```bash
# Testes de unidade
mvn test -Dtest=AluguelControllerTest

# Testes de integração
mvn test -Dtest=*IntegrationTest
```

## 📦 Estrutura do Projeto

```
alugafacil/
├── src/
│   ├── main/
│   │   ├── java/com/example/alugafacil/alugafacil/
│   │   │   ├── config/         # Configurações da aplicação
│   │   │   ├── controllers/    # Controladores da API
│   │   │   ├── dtos/          # Objetos de Transferência de Dados
│   │   │   ├── exceptions/    # Classes de exceção
│   │   │   ├── models/        # Entidades do domínio
│   │   │   ├── repositories/  # Repositórios JPA
│   │   │   └── services/      # Lógica de negócios
│   │   └── resources/         # Arquivos de configuração
│   └── test/                  # Testes automatizados
└── pom.xml                    # Configuração do Maven
```

## 📄 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## ✉️ Contato

Se tiver alguma dúvida ou sugestão, entre em contato:

- E-mail: danillobatista@gmail.com
