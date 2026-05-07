package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartaoVT {

    private final String numeroCartao; // O final sigifica que o valor não pode ser alterado depois da criação do cartao.
    private final String nomeTitular;
    private final TipoCartao tipo;
    private double saldo;
    private final List<Transacao> historico;

    public CartaoVT(String numeroCartao, String nomeTitular, TipoCartao tipo, double saldoInicial) {
        if (numeroCartao == null || numeroCartao.isBlank())
            throw new IllegalArgumentException("Número do cartão não pode ser vazio.");  //throw significa "lançar" throw new significa  "crie um erro e lance ele agora".
        if (nomeTitular == null || nomeTitular.isBlank())
            throw new IllegalArgumentException("Nome do titular não pode ser vazio.");
        if (saldoInicial < 0)
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");

        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.tipo = tipo;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();

        historico.add(new Transacao("Criação do cartão", saldoInicial, saldoInicial));
    }

    public void recarregar(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("Valor de recarga deve ser positivo.");

        this.saldo += valor;
        historico.add(new Transacao("Recarga", valor, saldo));
    }

    // Retorna o saldo após debitar, lança exceção se saldo insuficiente
    public double debitar(double valor) {
        if (valor <= 0)
            throw new IllegalArgumentException("O valor deve ser positivo.");
        if (saldo < valor)
            throw new SaldoInsuficienteException(saldo, valor);

        saldo -= valor;
        historico.add(new Transacao("Débito de passagem", valor, saldo));
        return saldo;
    }

    public String getNumeroCartao() { return numeroCartao; }
    public String getNomeTitular() { return nomeTitular; }
    public TipoCartao getTipo() { return tipo; }
    public double getSaldo() { return saldo; }
    public List<Transacao> getHistorico() { return Collections.unmodifiableList(historico); } //entrega a lista protegida contra modificações

    @Override
    public String toString() {
        return String.format("Cartão: %s | Titular: %s | Tipo: %s | Saldo: R$ %.2f",
                numeroCartao, nomeTitular, tipo.getDescricao(), saldo);
    }
}