import model.CartaoVT;
import model.TipoCartao;
import service.LeitorPassagem;

public class Main {

    public static void main(String[] args) {

        LeitorPassagem leitor = new LeitorPassagem();

        // --- Cenário 1: Passageiro comum com saldo suficiente ---
        CartaoVT cartaoComum = new CartaoVT("TRI-0001", "Carlos Silva", TipoCartao.COMUM, 10.00);
        leitor.processarPagamento(cartaoComum);

        // --- Cenário 2: Passageiro estudante ---
        CartaoVT cartaoEstudante = new CartaoVT("TRI-0002", "Ana Souza", TipoCartao.ESTUDANTE, 5.00);
        leitor.processarPagamento(cartaoEstudante);

        // --- Cenário 3: Idoso (gratuidade) ---
        CartaoVT cartaoIdoso = new CartaoVT("TRI-0003", "José Ferreira", TipoCartao.IDOSO, 0.00);
        leitor.processarPagamento(cartaoIdoso);

        // --- Cenário 4: Saldo insuficiente ---
        CartaoVT cartaoSemSaldo = new CartaoVT("TRI-0004", "Maria Oliveira", TipoCartao.COMUM, 3.00);
        leitor.processarPagamento(cartaoSemSaldo);

        // --- Cenário 5: Recarga e nova tentativa ---
        System.out.println("\n  >> Recarregando cartão de Maria...\n");
        cartaoSemSaldo.recarregar(10.00);
        leitor.processarPagamento(cartaoSemSaldo);

        // --- Extrato do cartão ---
        leitor.exibirExtrato(cartaoSemSaldo);
    }
}