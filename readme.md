# Apresentação dos Projetos de Cálculo de Empréstimos

## Estrutura do Projeto
O projeto é dividido em dois serviços principais: **Backend** e **Frontend**, gerenciados por um arquivo `docker-compose.yml`.

### docker-compose.yml
O arquivo `docker-compose.yml` define os seguintes serviços:

- **Backend**:
  - **Contexto**: `./calculadora-emprestimos-backend`
  - **Porta**: `8080`

- **Frontend**:
  - **Contexto**: `./calculadora-emprestimos-frontend`
  - **Porta**: `3000`
  - **Variável de Ambiente**: `REACT_APP_BACKEND_URL` configurada para `http://backend:8080`
  - **Dependências**: O frontend depende do backend para iniciar.

### Dockerfile do Backend
O `Dockerfile` do backend é estruturado em duas etapas:

1. **Builder**:
   - **Base**: `gradle:7.6-jdk17`
   - **Comando**: `gradle build --no-daemon`

2. **Runtime**:
   - **Base**: `openjdk:17-jdk-slim`
   - **Comando**: `java -jar app.jar`

### Dockerfile do Frontend
O `Dockerfile` do frontend também possui duas etapas:

1. **Construção**:
   - **Base**: `node:18-alpine`
   - **Comandos**: `npm install` e `npm run build`

2. **Execução**:
   - **Comando**: `serve -s build -l 3000`

### emprestimoService.js
O arquivo `emprestimoService.js` contém a função `calcularEmprestimo`:
- Faz uma requisição `POST` para a API de empréstimos.
- Utiliza a URL do backend configurada na variável de ambiente.
- Lida com erros caso a resposta não seja bem-sucedida.

## Conclusão
Este projeto oferece uma estrutura clara e eficiente para calcular empréstimos, utilizando tecnologias modernas e práticas recomendadas de desenvolvimento.
