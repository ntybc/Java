public class CartaoCredito implements MetodoPagamento {
    private String numeroCartao;
    private double limite;

    public CartaoCredito(String numeroCartao, double limite) {
        this.numeroCartao = numeroCartao;
        this.limite = limite;
    }

    @Override
    public void processarPagamento(double valor) {
        if (valor > limite) {
            System.out.println("Pagamento recusado: limite insuficiente.");
            return;
        }
        limite -= valor;
        System.out.printf("Pagamento de R$ %.2f aprovado no cartão %s.%n", valor, numeroCartao);
    }

    @Override
    public String obterDetalhes() {
        return "Cartão de Crédito - número: " + numeroCartao + ", limite disponível: R$ " + String.format("%.2f", limite);
    }
}