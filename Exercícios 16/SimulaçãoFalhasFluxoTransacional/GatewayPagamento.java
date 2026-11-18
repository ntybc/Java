// Exercício 5 - Serviço externo de cobrança (no teste vira mock)
public interface GatewayPagamento {
    void cobrar(double valor);
}
