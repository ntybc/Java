package cotacaoViagem;

import java.util.concurrent.CompletableFuture;

public class MainCotacao {

    private static final boolean SIMULAR_FALHA = false;

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        CompletableFuture<Double> passagens = CompletableFuture.supplyAsync(MainCotacao::cotarPassagens);
        CompletableFuture<Double> hospedagem = CompletableFuture.supplyAsync(MainCotacao::cotarHospedagem);

        CompletableFuture<String> pacote = passagens
                .thenCombine(hospedagem, (valorPassagens, valorHospedagem) ->
                        String.format("Pacote de viagem -> passagens: R$ %.2f | hospedagem: R$ %.2f | TOTAL: R$ %.2f",
                                valorPassagens, valorHospedagem, valorPassagens + valorHospedagem))
                .exceptionally(erro -> "Não foi possível montar o pacote: " + erro.getMessage());

        System.out.println("[main] Cotações em andamento...");
        System.out.println(pacote.join());

        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Tempo total: " + tempo + " ms (paralelo, ~1200 ms em vez de ~2000 ms)");
    }

    private static double cotarPassagens() {
        dormir(1200);
        System.out.println("[" + Thread.currentThread().getName() + "] Cotação de passagens pronta.");
        return 1850.00;
    }

    private static double cotarHospedagem() {
        dormir(800);
        if (SIMULAR_FALHA) {
            throw new RuntimeException("serviço de hospedagem indisponível");
        }
        System.out.println("[" + Thread.currentThread().getName() + "] Cotação de hospedagem pronta.");
        return 1320.50;
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}