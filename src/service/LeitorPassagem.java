package service;

import model.CartaoVT;
import model.SaldoInsuficienteException;

public class LeitorPassagem {

    private static final String SEPARADOR = "=".repeat(45);

    public void processarPagamento(CartaoVT cartao) {
        double tarifa = cartao.getTipo().getTarifa();

        System.out.println(SEPARADOR);
        System.out.printf("  Leitor TRI - Processando pagamento...%n");
        System.out.println(SEPARADOR);
        System.out.printf("  Titular : %s%n", cartao.getNomeTitular());
        System.out.printf("  Cartão  : %s%n", cartao.getNumeroCartao());
        System.out.printf("  Tipo    : %s%n", cartao.getTipo().getDescricao());
        System.out.println(SEPARADOR);

        if (tarifa == 0.00) {
            System.out.println("  ✔ GRATUIDADE CONFIRMADA");
            System.out.printf("  Passagem liberada. Saldo: R$ %.2f%n", cartao.getSaldo());
        } else {
            try {
                double saldoRestante = cartao.debitar(tarifa);
                System.out.printf("  ✔ PAGAMENTO APROVADO%n");
                System.out.printf("  Tarifa cobrada : R$ %.2f%n", tarifa);
                System.out.printf("  Saldo restante : R$ %.2f%n", saldoRestante);
            } catch (SaldoInsuficienteException e) {
                System.out.println("  ✘ PAGAMENTO NEGADO");
                System.out.println("  " + e.getMessage());
                System.out.println("  Por favor, recarregue seu cartão.");
            }
        }

        System.out.println(SEPARADOR);
    }

    /**
     * Exibe o extrato completo de transações do cartão.
     */
    public void exibirExtrato(CartaoVT cartao) {
        System.out.println(SEPARADOR);
        System.out.println("  EXTRATO DO CARTÃO");
        System.out.println(SEPARADOR);
        System.out.printf("  Titular: %s%n", cartao.getNomeTitular());

        if (cartao.getHistorico().isEmpty()) {
            System.out.println("  Nenhuma transação registrada.");
        } else {
            cartao.getHistorico().forEach(t -> System.out.println("  " + t));
        }

        System.out.printf("%n  Saldo atual: R$ %.2f%n", cartao.getSaldo());
        System.out.println(SEPARADOR);
    }
}