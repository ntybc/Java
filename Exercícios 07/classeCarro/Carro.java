package classeCarro;

public class Carro {
    private String modelo;
    private int ano;
    private int velocidadeAtual;

    public Carro(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidadeAtual = 0;
    }

    // Getter e setter para modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Apenas getter para ano (sem setter)
    public int getAno() {
        return ano;
    }

    // Apenas getter para velocidadeAtual (sem setter)
    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    // Métodos operacionais que alteram velocidadeAtual
    public void acelerar(int incremento) {
        if (incremento <= 0) {
            System.out.println("Erro: incremento deve ser positivo.");
            return;
        }
        this.velocidadeAtual += incremento;
    }

    public void frear(int decremento) {
        if (decremento <= 0) {
            System.out.println("Erro: decremento deve ser positivo.");
            return;
        }
        this.velocidadeAtual -= decremento;
        if (this.velocidadeAtual < 0) {
            this.velocidadeAtual = 0;
        }
    }

    // Método booleano de consulta
    public boolean isEmMovimento() {
        return velocidadeAtual > 0;
    }
}