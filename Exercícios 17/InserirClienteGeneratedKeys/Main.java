import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            Conexao.criarTabelas(conn);

            System.out.println("=== Inserindo clientes ===");
            ClienteDAO.inserirCliente(conn, "Nathalia", "nathalia@email.com");
            ClienteDAO.inserirCliente(conn, "Joao Silva", "joao@email.com");
            ClienteDAO.inserirCliente(conn, "Maria Souza", "maria@email.com");

            // Caso de falha: nome grande demais para o VARCHAR(100)
            System.out.println("\n=== Caso de falha (nome maior que 100 caracteres) ===");
            ClienteDAO.inserirCliente(conn, "A".repeat(150), "erro@email.com");

            System.out.println("\n=== Clientes na tabela ===");
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT id, nome, email FROM clientes")) {
                while (rs.next()) {
                    System.out.println(rs.getLong("id") + " | " + rs.getString("nome") + " | " + rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}
