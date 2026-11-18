import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            Conexao.criarTabelas(conn);

            // monta 500 mensagens de log
            List<String> mensagens = new ArrayList<>();
            for (int i = 1; i <= 500; i++) {
                mensagens.add("Mensagem de log número " + i);
            }

            System.out.println("=== Inserindo " + mensagens.size() + " logs em lote ===");
            LogDAO.inserirLoteLog(conn, mensagens);
            System.out.println("Total na tabela: " + contar(conn));

            // Caso de falha: mensagem maior que 255 caracteres, o lote para no erro (sem transação, a 1ª mensagem já foi gravada)
            System.out.println("\n=== Caso de falha (mensagem maior que 255 caracteres) ===");
            List<String> comErro = new ArrayList<>();
            comErro.add("Mensagem normal");
            comErro.add("X".repeat(300));
            LogDAO.inserirLoteLog(conn, comErro);
            System.out.println("Total na tabela: " + contar(conn));

            // Lista vazia
            System.out.println("\n=== Lista vazia ===");
            LogDAO.inserirLoteLog(conn, new ArrayList<>());
            System.out.println("Total na tabela: " + contar(conn));

            System.out.println("\n=== Primeiros 3 logs ===");
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT id, mensagem, data_registro FROM logs_sistema ORDER BY id LIMIT 3")) {
                while (rs.next()) {
                    System.out.println(rs.getLong("id") + " | " + rs.getString("mensagem") + " | " + rs.getTimestamp("data_registro"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    private static int contar(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM logs_sistema")) {
            rs.next();
            return rs.getInt(1);
        }
    }
}
