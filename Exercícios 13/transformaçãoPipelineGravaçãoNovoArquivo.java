import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class transformaçãoPipelineGravaçãoNovoArquivo {
    public static void main(String[] args) {
        Path origem = Path.of("clientes_bruto.txt");
        Path destino = Path.of("clientes_padronizado.txt");

        try (var stream = Files.lines(origem)) {
            List<String> nomesPadronizados = stream
                    .map(String::trim)
                    .filter(linha -> !linha.isBlank())
                    .map(transformaçãoPipelineGravaçãoNovoArquivo::capitalizar)
                    .collect(Collectors.toList());

            Files.write(destino, nomesPadronizados,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Arquivo padronizado criado: " + destino);
            System.out.println("Total de nomes processados: " + nomesPadronizados.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Capitaliza: primeira letra maiúscula, resto minúsculo
    private static String capitalizar(String nome) {
        if (nome == null || nome.isEmpty()) return nome;
        return nome.substring(0, 1).toUpperCase() +
               nome.substring(1).toLowerCase();
    }
}