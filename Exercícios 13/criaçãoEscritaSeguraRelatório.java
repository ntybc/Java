import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class criaçãoEscritaSeguraRelatório {
    public static void main(String[] args) {
        try {
            Path dir = Path.of("dados", "relatorios");
            Files.createDirectories(dir);

            Path arquivo = dir.resolve("sumario.txt");

            String conteudo = """
                === Relatório de Execução ===
                Timestamp: %s
                Status: Sistema iniciado com sucesso
                Diretório: %s
                """.formatted(
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                    dir.toAbsolutePath()
                );

            Files.writeString(arquivo, conteudo,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Arquivo criado em: " + arquivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}