public class ContaPoupanca extends Conta {
    private double taxaRendimento; // em porcentagem: 5 significa 5%

    public ContaPoupanca(String numero, double saldoInicial, double taxaRendimento) {
        super(numero, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        depositar(getSaldo() * taxaRendimento / 100);
    }
}