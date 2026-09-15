package classeFuncionario;

public class MainFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Ana Paula", "F1023", 3000.0);

        System.out.println("=== Dados iniciais ===");
        funcionario.exibirDados();

        System.out.println("\n=== Tentando aumento válido (3500.0) ===");
        funcionario.setSalario(3500.0);
        funcionario.exibirDados();

        System.out.println("\n=== Tentando redução (2000.0) ===");
        funcionario.setSalario(2000.0);
        funcionario.exibirDados();

        System.out.println("\n=== Tentando valor igual ao atual (3500.0) ===");
        funcionario.setSalario(3500.0);
        funcionario.exibirDados();
    }
}