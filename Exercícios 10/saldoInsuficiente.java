public class saldoInsuficiente {

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static class ContaCorrente {
        private String
public class ExSaldoInsuficiente {

    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static class ContaCorrente {
        private String numero;
        private double saldo;

        public ContaCorrente(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        public String getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public void sacar(double valor) throws SaldoInsuficienteException {
            if (valor > this.saldo) {
                throw new SaldoInsuficienteException(
                    "Falha na operacao: Saldo insuficiente para sacar R$ " + String.format("%.2f", valor) +
                    ". Saldo disponivel: R$ " + String.format("%.2f", this.saldo)
                );
            }
            this.saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        }
    }

    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("CC-3003", 500.00);

        System.out.println("Conta: " + conta.getNumero() + " | Saldo Inicial: R$ " + String.format("%.2f", conta.getSaldo()));

        try {
            System.out.println("\nTentando sacar R$ 200,00...");
            conta.sacar(200.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nTentando sacar R$ 400,00...");
            conta.sacar(400.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
} numero;
        private double saldo;

        public ContaCorrente(String numero, double saldoInicial) {
            this.numero = numero;
            this.saldo = saldoInicial;
        }

        public String getNumero() {
            return numero;
        }

        public double getSaldo() {
            return saldo;
        }

        public void sacar(double valor) throws SaldoInsuficienteException {
            if (valor > this.saldo) {
                throw new SaldoInsuficienteException(
                    "Falha na operacao: Saldo insuficiente para sacar R$ " + String.format("%.2f", valor) +
                    ". Saldo disponivel: R$ " + String.format("%.2f", this.saldo)
                );
            }
            this.saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso.");
        }
    }

    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("CC-3003", 500.00);

        System.out.println("Conta: " + conta.getNumero() + " | Saldo Inicial: R$ " + String.format("%.2f", conta.getSaldo()));

        try {
            System.out.println("\nTentando sacar R$ 200,00...");
            conta.sacar(200.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nTentando sacar R$ 400,00...");
            conta.sacar(400.00);
            System.out.println("Saldo restante: R$ " + String.format("%.2f", conta.getSaldo()));
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
}