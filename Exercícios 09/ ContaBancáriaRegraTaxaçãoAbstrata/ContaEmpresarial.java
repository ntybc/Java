public class ContaEmpresarial extends ContaBancaria {
    private static final double TAXA_FIXA = 30.00;
    private static final double TAXA_PERCENTUAL = 0.5; // em %

    public ContaEmpresarial(String numero, double saldoInicial) {
        super(numero, saldoInicial);
    }

    @Override
    public void cobrarTaxaMensal() {
        double taxaVariavel = getSaldo() * TAXA_PERCENTUAL / 100;
        double taxaTotal = TAXA_FIXA + taxaVariavel;
        debitar(taxaTotal);
        System.out.printf("Conta %s: taxa mensal de R$ %.2f cobrada (R$ %.2f fixa + R$ %.2f sobre saldo).%n",
                getNumero(), taxaTotal, TAXA_FIXA, taxaVariavel);
    }
}