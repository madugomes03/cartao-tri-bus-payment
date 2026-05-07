package model;

public class SaldoInsuficienteException extends RuntimeException {

    private final double saldoAtual;
    private final double valorNecessario;

    public SaldoInsuficienteException(double saldoAtual, double valorNecessario) {
        super(String.format(
                "Saldo insuficiente. Saldo atual: R$ %.2f | Necessário: R$ %.2f",
                saldoAtual, valorNecessario));
        this.saldoAtual = saldoAtual;
        this.valorNecessario = valorNecessario;
    }

    public double getSaldoAtual() { return saldoAtual; }
    public double getValorNecessario() { return valorNecessario; }
}