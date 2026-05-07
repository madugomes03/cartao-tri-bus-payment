# 🚌 Sistema de Validação de Transporte Público (TRI)

Este projeto é um simulador de validador de passagens de transporte público, desenvolvido em **Java**. O objetivo foi aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** e boas práticas de desenvolvimento de software em um cenário do cotidiano.

## Tecnologias e Conceitos Aplicados

Neste projeto, foquei em criar um código limpo, seguro e fácil de manter. As principais tecnologias e conceitos utilizados foram:

* **Java 17+**: Uso de recursos modernos da linguagem.
* **Encapsulamento e Imutabilidade**: Atributos privados e uso de `final` para garantir a integridade dos dados (como número do cartão e titular).
* **Polimorfismo com Enums**: Centralização das regras de tarifas (`COMUM`, `ESTUDANTE`, `IDOSO`, `PCD`) em um único lugar.
* **Tratamento de Exceções Personalizadas**: Criação da `SaldoInsuficienteException` para um fluxo de erro mais claro.
* **Programação Defensiva**: Validação de dados de entrada nos construtores e métodos para evitar estados inválidos do sistema.
* **Java Collections**: Uso de `ArrayList` para o histórico e `Collections.unmodifiableList` para proteger os dados de transações.

##  Estrutura do Projeto

O código está organizado em pacotes seguindo o padrão de mercado:

* `model`: Contém as entidades e dados do sistema (`CartaoVT`, `Transacao`, `TipoCartao`, `SaldoInsuficienteException`).
* `service`: Contém a lógica de negócio do leitor de passagens (`LeitorPassagem`).
* `app`: Ponto de entrada do sistema (`Main`).

## 🛠️ Como rodar o projeto

1.  Certifique-se de ter o **JDK 17** ou superior instalado.
2.  Clone o repositório:
    ```bash
    git clone [https://github.com/seu-usuario/validador-transporte-java.git](https://github.com/seu-usuario/validador-transporte-java.git)
    ```
3.  Abra o projeto no **IntelliJ IDEA** (ou sua IDE de preferência).
4.  Execute a classe `Main.java` localizada no pacote `app`.

## 📝 Exemplo de Saída (Console)

Ao rodar o sistema, você verá a simulação de diferentes cenários:
- Pagamento aprovado para diferentes categorias.
- Bloqueio de passagem por saldo insuficiente.
- Processo de recarga e atualização automática do extrato.
