public class aluno {

    String nome;
    String matricula;
    double nota1;
    double nota2;

    double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    String verificarAprovacao() {
        if (this.calcularMedia() > 7) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    void imprimirBoletim() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média final: " + this.calcularMedia());
        System.out.println("Situação: " + this.verificarAprovacao());
    }
}