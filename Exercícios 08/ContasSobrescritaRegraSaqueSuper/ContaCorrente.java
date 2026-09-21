public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 2.00;
    private double limiteChequeEspecial;

    public ContaCorrente(String numero, double saldoInicial, double limiteChequeEspecial) {
        super(numero, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    protected double limiteDisponivel() {
        return limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        super.sacar(valor + TAXA_SAQUE); // saque + taxa fixa, validado pela superclasse
    }
}