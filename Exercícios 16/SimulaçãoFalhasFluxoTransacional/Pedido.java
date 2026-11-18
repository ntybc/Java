// Exercício 5 - Entidade pedido (começa sempre como PENDENTE)
public class Pedido {

    private final double total;
    private StatusPedido status = StatusPedido.PENDENTE;

    public Pedido(double total) {
        this.total = total;
    }

    public double getTotal() { return total; }
    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }
}
