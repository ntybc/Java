public class Pix implements MetodoPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento de R$ %.2f aprovado via Pix.%n", valor);
    }

    @Override
    public String obterDetalhes() {
        return "Pix - chave: " + chavePix;
    }
}