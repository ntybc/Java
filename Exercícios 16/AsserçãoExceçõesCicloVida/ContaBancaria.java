// Exercício 2 - Código de produção
public class ContaBancaria {

    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        // não pode sacar valor zero ou negativo
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        // não pode sacar mais do que tem
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo disponível: " + saldo);
        }
        saldo -= valor;
    }
}
