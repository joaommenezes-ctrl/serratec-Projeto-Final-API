# 🛍️ API E-Commerce

## 📖 Descrição do Projeto
Este projeto consiste no desenvolvimento de uma **API RESTful para um sistema de E-Commerce**, com o objetivo de gerenciar **categorias, produtos, clientes e pedidos**.  

A aplicação foi construída utilizando o **framework Spring Boot** e segue o **padrão de arquitetura em camadas (Controller, Service, Repository, Entity)**, permitindo uma estrutura organizada, de fácil manutenção e escalável.  

Além das operações básicas de CRUD, o sistema integra serviços externos, realiza envio de e-mails e implementa tratamento centralizado de exceções.

---

## 🧩 Funcionalidades Principais

### 🔹 Categoria
- Inserir e editar categorias  
- Listar categorias existentes  

### 🔹 Produto
- Inserir e editar produtos  
- Cada produto está vinculado a uma categoria  
- Exibir a categoria associada ao produto  

### 🔹 Cliente
- Inserir e editar clientes  
- Consultar endereço automaticamente via [ViaCEP](https://viacep.com.br) ao cadastrar o CEP  
- Enviar e-mail ao cliente após cadastro ou atualização  

### 🔹 Pedido
- Inserir e editar pedidos  
- Cada pedido pertence a um cliente  
- Cada pedido pode conter múltiplos produtos (relação N:N)  
- Calcular valor total, desconto e quantidade por item  
- Alterar status do pedido (PENDENTE, PAGO, ENVIADO, CANCELADO)  

---

## 🧠 Tecnologias Utilizadas

| Tecnologia | Finalidade |
|-------------|-------------|
| **Java 17+** | Linguagem principal |
| **Spring Boot** | Framework base da aplicação |
| **Spring Web** | Criação dos endpoints REST |
| **Spring Data JPA** | Acesso e manipulação do banco de dados |
| **PostgreSQL** | Banco de dados |
| **Spring Boot Starter Mail** | Envio de e-mails |
| **RestTemplate** | Consumo da API ViaCEP |
| **Swagger (Springdoc OpenAPI)** | Documentação e testes da API |
| **Maven** | Gerenciador de dependências |

---

## 🧱 Arquitetura em Camadas

```text
controller  →  service  →  repository  →  entity
 ↑                 ↓
 swagger       exception
 viaCEP
```

- **Entity:** classes que representam as tabelas do banco  
- **Repository:** interfaces que acessam os dados via JPA  
- **Service:** lógica de negócio e validações  
- **Controller:** endpoints públicos da API  
- **Exception:** tratamento centralizado de erros  
- **DTO:** transporte controlado de dados entre as camadas  

---

## 🧩 Estrutura de Relacionamentos

| Entidade | Relacionamento |
|-----------|----------------|
| Categoria ↔ Produto | 1:N (uma categoria tem vários produtos) |
| Cliente ↔ Pedido | 1:N (um cliente pode ter vários pedidos) |
| Pedido ↔ Produto | N:N (um pedido pode ter vários produtos e vice-versa, via `PedidoItem`) |

---

## 🌐 Integração com API ViaCEP

A aplicação consome o serviço [ViaCEP](https://viacep.com.br/ws/) para buscar o endereço completo de um cliente a partir do seu CEP durante o cadastro ou atualização.

---

## ✉️ Envio de E-mail

Sempre que um cliente é **cadastrado** ou **atualizado**, a aplicação envia um e-mail notificando a ação realizada.  
A funcionalidade utiliza o `Spring Boot Starter Mail` com servidor SMTP configurável no `application.properties`.

---

## 👥 Integrantes do Projeto

| Nome |
|------|
| **João Menezes** |
| **Willian José** |
| **José Arthur** |
| **Nicole** |
| **Nélio** |
| **Gabriel Belinski** |
---

## 🧾 Licença
Este projeto foi desenvolvido para fins **educacionais**, no contexto da disciplina de **Desenvolvimento de APIs com Spring Boot**.  



### 💡 “Código limpo é aquele que expressa claramente o que faz.”
