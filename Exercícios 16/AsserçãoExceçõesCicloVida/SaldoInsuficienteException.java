// Exercício 2 - Exceção personalizada lançada quando não há saldo
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
