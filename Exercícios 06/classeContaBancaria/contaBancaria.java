public class contaBancaria {

    String titular;
    String numeroConta;
    double saldo = 0;

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido");
        }
    }

    void consultarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }
}