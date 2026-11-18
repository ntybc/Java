// Exercício 5 - Exceção lançada quando o gateway recusa o pagamento
public class PagamentoRecusadoException extends RuntimeException {

    public PagamentoRecusadoException(String mensagem) {
        super(mensagem);
    }
}
