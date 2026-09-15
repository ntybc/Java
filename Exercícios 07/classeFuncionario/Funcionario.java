package classeFuncionario;

public class Funcionario {
    private String nome;
    private String matricula;
    private double salario;

    public Funcionario(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    // Regra de negócio: só aceita aumento, nunca redução via setter
    public void setSalario(double novoSalario) {
        if (novoSalario <= this.salario) {
            System.out.println("Erro: novo salário (" + novoSalario +
                    ") deve ser maior que o salário atual (" + this.salario + "). Alteração não realizada.");
            return;
        }
        this.salario = novoSalario;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Salário: " + salario);
    }
}
