package ClasseProduto;
public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    // Construtor completo
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.setPreco(preco);
        this.setQuantidadeEstoque(quantidadeEstoque);
    }

    // Construtor sobrecarregado (sem estoque, assume 0)
    public Produto(String nome, double preco) {
        this(nome, preco, 0); // reaproveita o construtor completo
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("Erro: preço não pode ser negativo. Valor mantido: " + this.preco);
            return;
        }
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            System.out.println("Erro: estoque não pode ser negativo. Valor mantido: " + this.quantidadeEstoque);
            return;
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double calcularValorTotalEmEstoque() {
        return preco * quantidadeEstoque;
    }
}