package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private final String tipo;
    private final double valor;
    private final double saldoApos;
    private final LocalDateTime dataHora;

    public Transacao(String tipo, double valor, double saldoApos) {
        this.tipo = tipo;
        this.valor = valor;
        this.saldoApos = saldoApos;
        this.dataHora = LocalDateTime.now();
    }

    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public double getSaldoApos() { return saldoApos; }
    public LocalDateTime getDataHora() { return dataHora; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %s | Valor: R$ %.2f | Saldo após: R$ %.2f",
                dataHora.format(fmt), tipo, valor, saldoApos);
    }
}