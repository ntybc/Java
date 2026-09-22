public abstract class ContaBancaria {
    private String numero;
    private double saldo;

    public ContaBancaria(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    protected double getSaldo() {
        return saldo;
    }

    protected void debitar(double valor) {
        saldo -= valor;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
    }

    public void consultarSaldo() {
        System.out.printf("Conta %s - saldo: R$ %.2f%n", numero, saldo);
    }

    public abstract void cobrarTaxaMensal();
}