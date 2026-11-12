import java.util.List;
import java.util.Comparator;
import java.util.Optional;

public class estatisticasNumericas {

    record Produto(String nome, double preco) {}

    public static void main(String[] args) {
        List<Produto> produtos = List.of(
            new Produto("Notebook", 4500.00),
            new Produto("Mouse", 80.00),
            new Produto("Teclado", 250.00),
            new Produto("Monitor", 1200.00),
            new Produto("Headset", 320.00),
            new Produto("Webcam", 410.00)
        );

        
        double total = produtos.stream()
            .mapToDouble(Produto::preco)
            .sum();

        double totalReduce = produtos.stream()
            .map(Produto::preco)
            .reduce(0.0, Double::sum);

       
        double media = produtos.stream()
            .mapToDouble(Produto::preco)
            .average()
            .orElse(0.0);

        Optional<Produto> maisCaro = produtos.stream()
            .max(Comparator.comparingDouble(Produto::preco));

        System.out.printf("Total: R$ %.2f%n", total);
        System.out.printf("Total (reduce): R$ %.2f%n", totalReduce);
        System.out.printf("Média: R$ %.2f%n", media);
        maisCaro.ifPresent(p ->
            System.out.println("Mais caro: " + p.nome() + " - R$ " + p.preco()));
    }
}