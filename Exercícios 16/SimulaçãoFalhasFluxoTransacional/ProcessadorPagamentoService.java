// Exercício 5 - Código de produção
// Fluxo: cobra no gateway -> marca como PAGO -> salva no repositório.
// Se a cobrança falhar, a exceção interrompe o fluxo e nada é salvo.
public class ProcessadorPagamentoService {

    private final GatewayPagamento gateway;
    private final PedidoRepository repository;

    public ProcessadorPagamentoService(GatewayPagamento gateway, PedidoRepository repository) {
        this.gateway = gateway;
        this.repository = repository;
    }

    public void processar(Pedido pedido) {
        gateway.cobrar(pedido.getTotal());
        pedido.setStatus(StatusPedido.PAGO);
        repository.atualizar(pedido);
    }
}
