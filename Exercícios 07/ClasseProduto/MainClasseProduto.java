package ClasseProduto;

public class MainClasseProduto {
    public static void main(String[] args) {
        // Produto A - construtor completo (3 parâmetros)
        Produto produtoA = new Produto("Notebook", 3500.00, 10);

        // Produto B - construtor sobrecarregado (2 parâmetros)
        Produto produtoB = new Produto("Mouse", 50.00);

        System.out.println("=== Produto A ===");
        System.out.println("Nome: " + produtoA.getNome());
        System.out.println("Preço: " + produtoA.getPreco());
        System.out.println("Estoque: " + produtoA.getQuantidadeEstoque());
        System.out.println("Valor total em estoque: " + produtoA.calcularValorTotalEmEstoque());

        System.out.println("\n=== Produto B ===");
        System.out.println("Nome: " + produtoB.getNome());
        System.out.println("Preço: " + produtoB.getPreco());
        System.out.println("Estoque (deve ser 0): " + produtoB.getQuantidadeEstoque());

        // Testando validação do setPreco com valor negativo
        System.out.println("\n=== Teste de validação ===");
        System.out.println("Tentando setPreco(-10.0) no Produto A...");
        produtoA.setPreco(-10.0);
        System.out.println("Preço após tentativa inválida: " + produtoA.getPreco());
    }
}