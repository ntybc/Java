import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class leituraLinhaLinhaProcessamentoFuncional {
    public static void main(String[] args) {
        Path path = Path.of("servidor.log");

        try (var linhas = Files.lines(path)) {
            List<String> erros = linhas
                    .filter(linha -> linha.startsWith("[ERROR]"))
                    .map(linha -> linha.substring(8).trim()) // remove "[ERROR] "
                    .collect(Collectors.toList());

            System.out.println("Total de erros encontrados: " + erros.size());
            System.out.println("Mensagens de erro:");
            erros.forEach(msg -> System.out.println(" - " + msg));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}