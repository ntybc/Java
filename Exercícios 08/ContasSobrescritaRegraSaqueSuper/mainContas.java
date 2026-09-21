public class mainContas {
    public static void main(String[] args) {
        System.out.println("=== Conta Poupança ===");
        ContaPoupanca poupanca = new ContaPoupanca("001-P", 1000, 5);
        poupanca.depositar(500);
        poupanca.sacar(200);
        poupanca.aplicarRendimento();
        poupanca.exibirSaldo();
        poupanca.sacar(5000);
        poupanca.exibirSaldo();

        System.out.println();

        System.out.println("=== Conta Corrente ===");
        ContaCorrente corrente = new ContaCorrente("002-C", 300, 500);
        corrente.sacar(100);
        corrente.exibirSaldo();
        corrente.sacar(600);
        corrente.exibirSaldo();
        corrente.sacar(100);
        corrente.exibirSaldo();
    }
}