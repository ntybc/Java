public interface MetodoPagamento {
    void processarPagamento(double valor);
    String obterDetalhes();
}