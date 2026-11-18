import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Classe auxiliar: abre a conexão e cria as tabelas de exemplo.
public class Conexao {

    // H2 em memória (não precisa instalar nada).
    // Para PostgreSQL: "jdbc:postgresql://localhost:5432/meubanco"
    // Para MySQL:      "jdbc:mysql://localhost:3306/meubanco"
    // (e colocar o driver .jar do banco na pasta lib)
    private static final String URL = "jdbc:h2:mem:exercicio17;DB_CLOSE_DELAY=-1";
    private static final String USUARIO = "sa";
    private static final String SENHA = "";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void criarTabelas(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE contas (id BIGINT AUTO_INCREMENT PRIMARY KEY, titular VARCHAR(100), saldo DOUBLE)");
            st.execute("INSERT INTO contas (titular, saldo) VALUES ('Nathalia', 1000.00)");
            st.execute("INSERT INTO contas (titular, saldo) VALUES ('Joao', 500.00)");
        }
    }
}
