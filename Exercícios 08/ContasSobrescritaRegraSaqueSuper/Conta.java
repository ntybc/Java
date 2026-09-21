public class Conta {
    private String numero;
    private double saldo;

    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    // quanto além do saldo a conta permite sacar (0 para conta comum)
    protected double limiteDisponivel() {
        return 0.0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        if (valor > saldo + limiteDisponivel()) {
            System.out.println("Saque recusado: saldo/limite insuficiente.");
            return;
        }
        saldo -= valor;
    }

    public void exibirSaldo() {
        System.out.printf("Conta %s - saldo: R$ %.2f%n", numero, saldo);
    }
}