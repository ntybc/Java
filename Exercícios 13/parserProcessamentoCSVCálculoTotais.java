import java.nio.file.*;
import java.util.List;

public class parserProcessamentoCSVCálculoTotais{
    public static void main(String[] args) {
        Path path = Path.of("produtos.csv");

        try {
            List<String> linhas = Files.readAllLines(path);
            double totalInventario = 0.0;

            // pula o cabeçalho (índice 0)
            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i).trim();
                if (linha.isEmpty()) continue;

                try {
                    String[] campos = linha.split(",");
                    String nome = campos[0].trim();
                    int quantidade = Integer.parseInt(campos[1].trim());
                    double preco = Double.parseDouble(campos[2].trim());

                    double totalItem = quantidade * preco;
                    totalInventario += totalItem;

                    System.out.printf("%s: %d x %.2f = %.2f%n",
                            nome, quantidade, preco, totalItem);

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Linha inválida ignorada: " + linha);
                }
            }

            System.out.printf("%nValor total do inventário: %.2f%n", totalInventario);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}