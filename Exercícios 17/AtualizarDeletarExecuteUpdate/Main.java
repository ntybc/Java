import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            Conexao.criarTabelas(conn);
            listar(conn, "Estado inicial");

            System.out.println("\n=== Atualizando salário do ID 1 (existe) ===");
            FuncionarioDAO.atualizarSalario(conn, 1L, 3500.00);

            System.out.println("\n=== Atualizando salário do ID 99 (não existe) ===");
            FuncionarioDAO.atualizarSalario(conn, 99L, 5000.00);

            System.out.println("\n=== Deletando o ID 2 (existe) ===");
            FuncionarioDAO.deletarPorId(conn, 2L);

            System.out.println("\n=== Deletando o ID 99 (não existe) ===");
            FuncionarioDAO.deletarPorId(conn, 99L);

            System.out.println();
            listar(conn, "Estado final");
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    private static void listar(Connection conn, String titulo) throws SQLException {
        System.out.println("=== " + titulo + " ===");
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, nome, salario FROM funcionarios ORDER BY id")) {
            while (rs.next()) {
                System.out.println(rs.getLong("id") + " | " + rs.getString("nome") + " | R$ " + rs.getDouble("salario"));
            }
        }
    }
}
