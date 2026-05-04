# 🛒 Sistema de Pedidos - E-commerce (Design Patterns)

## 📌 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de simular o funcionamento de um sistema de pedidos de um e-commerce, aplicando na prática conceitos de Programação Orientada a Objetos e padrões de projeto.

A ideia principal foi construir um sistema simples, porém bem estruturado, capaz de controlar o fluxo de um pedido desde sua criação até sua finalização, respeitando regras reais de negócio e garantindo organização no código.

Além disso, o projeto foi pensado para ser flexível e fácil de evoluir, permitindo a adição de novas funcionalidades sem a necessidade de alterar partes já existentes do sistema.

---

## 🎯 Objetivo do Trabalho

O objetivo deste trabalho foi aplicar padrões de projeto para resolver problemas comuns no desenvolvimento de software, como:

* Controle de estados de um objeto
* Variação de comportamentos (cálculo de frete)
* Redução de complexidade no código
* Melhoria na organização e manutenção do sistema

---

## 🧠 Padrões de Projeto Utilizados

### 🔹 State (Padrão Comportamental)

O padrão **State** foi utilizado para controlar o ciclo de vida do pedido.

Na prática, isso significa que o pedido muda de comportamento dependendo do seu estado atual, sem precisar de várias estruturas condicionais (`if/else`).

Estados implementados:

* **Aguardando Pagamento**
* **Pago**
* **Enviado**
* **Cancelado**

Cada estado possui suas próprias regras, garantindo que apenas transições válidas sejam permitidas.

📌 Exemplo:

* Um pedido não pode ser enviado sem estar pago
* Um pedido cancelado não pode voltar para outro estado

Esse padrão torna o código mais organizado e evita erros de lógica.

---

### 🔹 Strategy (Padrão Comportamental)

O padrão **Strategy** foi aplicado no cálculo do frete.

Ele permite que diferentes formas de cálculo sejam utilizadas sem alterar a estrutura principal do sistema.

Estratégias implementadas:

* **Frete Terrestre** → 5% do valor do pedido
* **Frete Aéreo** → 10% do valor do pedido

📌 Vantagem:
Se no futuro surgir um novo tipo de frete (ex: marítimo), basta criar uma nova classe, sem modificar o código existente.

---

## ⚙️ Regras de Negócio

O sistema segue as seguintes regras:

* Todo pedido inicia como **AGUARDANDO PAGAMENTO**
* Pode ser:

  * Pago
  * Cancelado
* Após pago:

  * Pode ser enviado
  * Não pode ser pago novamente
* Após enviado:

  * Não pode mais sofrer alterações
* Pedido cancelado:

  * Não pode mudar de estado

Essas regras foram implementadas utilizando o padrão **State**, garantindo consistência no sistema.

---

## 🏗️ Estrutura do Projeto

O projeto foi organizado em camadas para facilitar o entendimento e manutenção:

```bash
src/main/java/com/exemple/pedido
 ├── controller   → Responsável pelas APIs
 ├── model        → Entidades do sistema
 ├── service      → Regras de negócio
 ├── repository   → Acesso ao banco de dados
 ├── state        → Implementação dos estados do pedido
 └── strategy     → Cálculo de frete
```

---

## 🧩 Diagrama de Classes

O sistema foi modelado utilizando UML, representando:

* A classe **Pedido** como entidade principal
* O padrão **State** para controle de status
* O padrão **Strategy** para cálculo de frete

📌 *(Inserir aqui a imagem do diagrama UML gerado no Visual Paradigm)*

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Banco de dados H2
* Maven
* Postman
* IntelliJ IDEA

---

## ▶️ Como Executar o Projeto

1. Abrir o projeto no IntelliJ
2. Executar a classe principal:

```java
PedidoApplication
```

3. A aplicação será iniciada em:

```
http://localhost:8080
```

---

## 📬 Endpoints da API

### 🔹 Criar Pedido

```http
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

```http
POST /pedidos/{id}/pagar
```

---

### 🔹 Cancelar Pedido

```http
POST /pedidos/{id}/cancelar
```

---

### 🔹 Enviar Pedido

```http
POST /pedidos/{id}/enviar
```

---

### 🔹 Calcular Frete

```http
GET /pedidos/{id}/frete
```

---

## 🧪 Testes da Aplicação

Os testes foram realizados utilizando o Postman, permitindo validar:

* Criação de pedidos
* Mudança de estados
* Restrições de regras de negócio
* Cálculo correto do frete

Durante os testes, foi possível observar que o sistema bloqueia ações inválidas, como tentar enviar um pedido não pago ou alterar um pedido cancelado.

---

## 💾 Persistência de Dados

Foi utilizado o banco de dados em memória **H2**, que permite:

* Execução rápida
* Testes simples
* Sem necessidade de instalação externa

---

## 📌 Considerações Finais

A aplicação dos padrões **State** e **Strategy** foi essencial para resolver os problemas propostos de forma organizada e escalável.

O sistema desenvolvido apresenta:

✔️ Código limpo e bem estruturado
✔️ Facilidade de manutenção
✔️ Possibilidade de expansão
✔️ Separação clara de responsabilidades

Esse projeto demonstra, na prática, como o uso de padrões de projeto pode melhorar significativamente a qualidade de um software.

---

## 👨‍💻 Autor

Vinicius Oliveira
