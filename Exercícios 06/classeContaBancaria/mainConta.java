public class mainConta {

    public static void main(String[] args) {

        contaBancaria conta = new contaBancaria();
        conta.titular = "Nathalia Cardoso";
        conta.numeroConta = "12345-6";

        System.out.println("=== Conta criada ===");
        conta.consultarSaldo();

        System.out.println("\n--- Depósito de 100 ---");
        conta.depositar(100);
        conta.consultarSaldo();

        System.out.println("\n--- Depósito inválido de -50 ---");
        conta.depositar(-50);
        conta.consultarSaldo();

        System.out.println("\n--- Saque de 30 ---");
        conta.sacar(30);
        conta.consultarSaldo();

        System.out.println("\n--- Saque inválido de 1000 ---");
        conta.sacar(1000);
        conta.consultarSaldo();

        System.out.println("\n--- Saque inválido de -10 ---");
        conta.sacar(-10);
        conta.consultarSaldo();
    }
}