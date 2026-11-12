import java.nio.file.*;
import java.util.stream.Stream;

public class varreduraFiltragemDiretórios {
    public static void main(String[] args) {
        Path raiz = Path.of(".");
        try (Stream<Path> walk = Files.walk(raiz)) {
            long totalBytes = walk
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .mapToLong(p -> {
                        try {
                            long tamanho = Files.size(p);
                            Path relativo = raiz.relativize(p);
                            System.out.printf("%s → %d bytes%n", relativo, tamanho);
                            return tamanho;
                        } catch (Exception e) {
                            return 0L;
                        }
                    })
                    .sum();

            System.out.println("\nTamanho total dos arquivos .java: " + totalBytes + " bytes");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}