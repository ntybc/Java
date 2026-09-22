public class ContaCorrente extends ContaBancaria {
    private static final double TAXA_FIXA = 15.00;

    public ContaCorrente(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        debitar(TAXA_FIXA);
        System.out.printf("Conta %s: taxa mensal fixa de R$ %.2f cobrada.%n", getNumero(), TAXA_FIXA);
    }
}