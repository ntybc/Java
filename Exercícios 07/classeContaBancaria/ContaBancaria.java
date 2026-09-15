package classeContaBancaria;

public class ContaBancaria {
    private final String numeroConta; // imutável após criação
    private String titular;
    private double saldo;

    // Construtor obrigatório: numeroConta e titular, saldo inicia em 0
    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Construtor sobrecarregado: aceita depósito inicial
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = (saldoInicial < 0) ? 0.0 : saldoInicial;
    }

    // Getter apenas (sem setter) — numeroConta é imutável
    public String getNumeroConta() {
        return numeroConta;
    }

    // Getter e setter para titular
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    // Getter apenas para saldo — sem setter direto
    public double getSaldo() {
        return saldo;
    }

    // Método operacional para depositar
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de depósito deve ser positivo.");
            return;
        }
        this.saldo += valor;
    }

    // Método operacional para sacar
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: valor de saque deve ser positivo.");
            return;
        }
        if (valor > this.saldo) {
            System.out.println("Erro: saldo insuficiente. Saldo atual: " + this.saldo);
            return;
        }
        this.saldo -= valor;
    }
}