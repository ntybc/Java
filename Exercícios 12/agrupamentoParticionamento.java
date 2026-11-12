import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class agrupamentoParticionamento {

    record Aluno(String nome, String curso, double notaFinal) {}

    public static void main(String[] args) {
        List<Aluno> alunos = List.of(
            new Aluno("Ana", "Engenharia", 8.5),
            new Aluno("Bruno", "Engenharia", 6.0),
            new Aluno("Carla", "Medicina", 9.2),
            new Aluno("Diego", "Medicina", 7.0),
            new Aluno("Elisa", "Direito", 7.5),
            new Aluno("Fabio", "Direito", 5.5),
            new Aluno("Gabi", "Engenharia", 7.1)
        );

        Map<String, List<Aluno>> porCurso = alunos.stream()
            .collect(Collectors.groupingBy(Aluno::curso));

        System.out.println("=== Por curso ===");
        porCurso.forEach((curso, lista) -> {
            System.out.println(curso + ":");
            lista.forEach(a -> System.out.println("   " + a.nome() + " (" + a.notaFinal() + ")"));
        });

        Map<Boolean, List<Aluno>> aprovacao = alunos.stream()
            .collect(Collectors.partitioningBy(a -> a.notaFinal() > 7.0));

        System.out.println("\n=== Aprovados ===");
        aprovacao.get(true).forEach(a -> System.out.println("   " + a.nome()));

        System.out.println("=== Reprovados ===");
        aprovacao.get(false).forEach(a -> System.out.println("   " + a.nome()));
    }
}