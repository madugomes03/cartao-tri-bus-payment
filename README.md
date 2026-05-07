# 🚌 Sistema de Validação de Transporte Público (TRI)

Este projeto é um simulador de validador de passagens de transporte público, desenvolvido em **Java**. O objetivo foi aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** e boas práticas de desenvolvimento de software em um cenário do cotidiano.

## Tecnologias e Conceitos Aplicados

Neste projeto, foquei em criar um código limpo, seguro e fácil de manter. As principais tecnologias e conceitos utilizados foram:

* **Java 17+**
* **Encapsulamento e Imutabilidade**: Atributos privados e uso de `final` para garantir a integridade dos dados (como número do cartão e titular).
* **Enums**: Centralização das regras de tarifas (`COMUM`, `ESTUDANTE`, `IDOSO`, `PCD`) em um único lugar.
* **Tratamento de Exceções Personalizadas**: Criação da `SaldoInsuficienteException` para um fluxo de erro mais claro.
* **Programação Defensiva**: Validação de dados de entrada nos construtores e métodos para evitar estados inválidos do sistema.
* **Java Collections**: Uso de `ArrayList` para o histórico e `Collections.unmodifiableList` para proteger os dados de transações.

##  Estrutura do Projeto

O código está organizado em pacotes seguindo o padrão de mercado:

* `model`: Contém as entidades e dados do sistema (`CartaoVT`, `Transacao`, `TipoCartao`, `SaldoInsuficienteException`).
* `service`: Contém a lógica de negócio do leitor de passagens (`LeitorPassagem`).
* `app`: Ponto de entrada do sistema (`Main`).

## Como rodar o projeto

1.  Certifique-se de ter o **JDK 17** ou superior instalado.
2.  Clone o repositório:
    ```bash
    git clone [https://github.com/seu-usuario/validador-transporte-java.git](https://github.com/seu-usuario/validador-transporte-java.git)
    ```
3.  Abra o projeto no **IntelliJ IDEA** (ou sua IDE de preferência).
4.  Execute a classe `Main.java` localizada no pacote `app`.

## Exemplo de Saída (Console)

Ao rodar o sistema, você verá a simulação de diferentes cenários:

- Pagamento aprovado para diferentes categorias.

<img width="487" height="773" alt="Captura de tela 2026-05-07 200720" src="https://github.com/user-attachments/assets/d030e261-d78c-4be0-9470-9dd16a97024c" />


- Bloqueio de passagem por saldo insuficiente.


<img width="793" height="303" alt="Captura de tela 2026-05-07 200744" src="https://github.com/user-attachments/assets/d1c9fadc-5bc2-4da3-99b3-427c47667e9e" />


- Processo de recarga e atualização automática do extrato.

  <img width="866" height="637" alt="Captura de tela 2026-05-07 200757" src="https://github.com/user-attachments/assets/fe6e991a-1530-4bd2-be70-aee611037eac" />



