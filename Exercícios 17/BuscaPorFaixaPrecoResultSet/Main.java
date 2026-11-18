import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            Conexao.criarTabelas(conn);

            System.out.println("=== Produtos entre R$ 10,00 e R$ 100,00 ===");
            imprimir(ProdutoDAO.buscarPorFaixaPreco(conn, 10, 100));

            System.out.println("\n=== Produtos entre R$ 0,00 e R$ 5,00 ===");
            imprimir(ProdutoDAO.buscarPorFaixaPreco(conn, 0, 5));

            // Caso sem resultado
            System.out.println("\n=== Produtos entre R$ 1000,00 e R$ 2000,00 ===");
            imprimir(ProdutoDAO.buscarPorFaixaPreco(conn, 1000, 2000));
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    private static void imprimir(List<Produto> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum produto encontrado nessa faixa de preço.");
            return;
        }
        for (Produto p : lista) {
            System.out.println(p);
        }
        System.out.println("Total: " + lista.size() + " produto(s)");
    }
}
