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
            st.execute("CREATE TABLE produtos (id BIGINT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), preco DOUBLE, estoque INT)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Caneta', 2.50, 100)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Caderno', 18.90, 40)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Mochila', 120.00, 15)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Mouse', 45.00, 25)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Teclado', 89.90, 10)");
            st.execute("INSERT INTO produtos (nome, preco, estoque) VALUES ('Monitor', 650.00, 5)");
        }
    }
}
