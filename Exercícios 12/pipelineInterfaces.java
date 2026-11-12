import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class pipelineInterfaces {

    record Funcionario(String nome, String departamento, double salario) {}

    public static void main(String[] args) {
        List<Funcionario> funcionarios = List.of(
            new Funcionario("Ana", "TI", 5000.00),
            new Funcionario("Bruno", "RH", 3500.00),
            new Funcionario("Carla", "TI", 7200.00),
            new Funcionario("Diego", "Financeiro", 4800.00),
            new Funcionario("Elisa", "TI", 6100.00)
        );

        // 1. Predicate: apenas do departamento TI
        Predicate<Funcionario> ehDeTI =
            f -> "TI".equalsIgnoreCase(f.departamento());

        // 2. Function: salário com reajuste projetado de 10%
        Function<Funcionario, Double> salarioReajustado =
            f -> f.salario() * 1.10;

        // 3. Consumer: imprimir o valor formatado
        Consumer<Double> imprimirValor =
            v -> System.out.printf("Salário projetado: R$ %.2f%n", v);

        // Pipeline único encadeando as três interfaces
        funcionarios.stream()
            .filter(ehDeTI)
            .map(salarioReajustado)
            .forEach(imprimirValor);
    }
}