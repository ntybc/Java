package classeContaBancaria;

public class MainContaBancaria {
    public static void main(String[] args) {
        // Conta com saldo inicial zero
        ContaBancaria contaA = new ContaBancaria("12345-6", "João Silva");

        // Conta com depósito inicial
        ContaBancaria contaB = new ContaBancaria("98765-4", "Maria Souza", 1000.0);

        System.out.println("=== Conta A ===");
        System.out.println("Número: " + contaA.getNumeroConta());
        System.out.println("Titular: " + contaA.getTitular());
        System.out.println("Saldo inicial: " + contaA.getSaldo());

        contaA.depositar(500.0);
        System.out.println("Saldo após depósito de 500: " + contaA.getSaldo());

        contaA.sacar(200.0);
        System.out.println("Saldo após saque de 200: " + contaA.getSaldo());

        System.out.println("\n=== Teste de saque maior que saldo ===");
        contaA.sacar(10000.0);
        System.out.println("Saldo permanece: " + contaA.getSaldo());

        System.out.println("\n=== Conta B ===");
        System.out.println("Número: " + contaB.getNumeroConta());
        System.out.println("Titular: " + contaB.getTitular());
        System.out.println("Saldo inicial (com depósito): " + contaB.getSaldo());

        // Testando setTitular
        contaB.setTitular("Maria Souza Lima");
        System.out.println("Titular atualizado: " + contaB.getTitular());
    }
}
