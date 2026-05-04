# 🛒 Sistema de Pedidos - E-commerce (Design Patterns)

## 📌 Descrição do Projeto

Este projeto foi desenvolvido com o objetivo de implementar um sistema de controle de pedidos de um e-commerce, aplicando conceitos de Programação Orientada a Objetos e padrões de projeto.

O sistema permite gerenciar o ciclo de vida de um pedido, respeitando regras de negócio relacionadas aos estados do pedido e ao cálculo de frete.

---

## 🎯 Objetivo

Aplicar padrões de projeto para:

* Controlar os estados de um pedido
* Calcular o frete de forma flexível
* Garantir organização, reutilização e manutenção do código

---

## 🧠 Padrões de Projeto Utilizados

### 🔹 State (Comportamental)

O padrão **State** foi utilizado para controlar os estados do pedido.

✔️ Permite que o objeto altere seu comportamento conforme seu estado interno muda.

Estados implementados:

* Aguardando Pagamento
* Pago
* Enviado
* Cancelado

✔️ Evita o uso de múltiplos `if/else`
✔️ Facilita a manutenção e expansão do sistema

---

### 🔹 Strategy (Comportamental)

O padrão **Strategy** foi utilizado para o cálculo do frete.

✔️ Permite definir diferentes algoritmos de cálculo de frete de forma intercambiável.

Estratégias implementadas:

* Frete Terrestre → 5% do valor
* Frete Aéreo → 10% do valor

✔️ Facilita a adição de novos tipos de frete

---

## ⚙️ Regras de Negócio

* O pedido inicia com status **AGUARDANDO PAGAMENTO**
* Pode ser:

  * Pago
  * Cancelado
* Após pago:

  * Pode ser enviado
  * Não pode ser pago novamente
* Após enviado:

  * Não pode mais ser alterado
* Pedido cancelado:

  * Não pode mudar de estado

---

## 🏗️ Estrutura do Projeto

```
src/main/java/com/exemple/pedido
 ├── controller
 ├── model
 ├── service
 ├── repository
 ├── state
 └── strategy
```

---

## 🧩 Diagrama de Classes

O sistema foi modelado utilizando UML com:

* Classe Pedido como entidade principal
* Interface EstadoPedido com implementações de estados
* Interface FreteStrategy com implementações de frete

(Adicionar aqui a imagem do diagrama UML)

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* Postman

---

## ▶️ Como Executar

1. Abrir o projeto no IntelliJ
2. Executar a classe:

```
PedidoApplication
```

3. A aplicação irá rodar em:

```
http://localhost:8080
```

---

## 📬 Endpoints da API

### 🔹 Criar Pedido

```
POST /pedidos
```

Body:

```json
{
  "valor": 200,
  "tipoFrete": "AEREO"
}
```

---

### 🔹 Pagar Pedido

```
POST /pedidos/{id}/pagar
```

---

### 🔹 Cancelar Pedido

```
POST /pedidos/{id}/cancelar
```

---

### 🔹 Enviar Pedido

```
POST /pedidos/{id}/enviar
```

---

### 🔹 Calcular Frete

```
GET /pedidos/{id}/frete
```

---

## 🧪 Testes

Os testes foram realizados utilizando o Postman, garantindo:

* Criação de pedidos
* Transição de estados
* Validação das regras de negócio
* Cálculo correto do frete

---

## 💾 Persistência

Os dados são persistidos utilizando banco em memória **H2**, permitindo testes rápidos e simples.

---

## 📌 Considerações Finais

O uso dos padrões **State** e **Strategy** proporcionou:

✔️ Código mais organizado
✔️ Facilidade de manutenção
✔️ Maior escalabilidade
✔️ Melhor separação de responsabilidades

O sistema atende completamente aos requisitos propostos, aplicando boas práticas de desenvolvimento orientado a objetos.

---

## 👨‍💻 Autor

Vinicius Oliveira
