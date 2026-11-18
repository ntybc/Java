import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class LogDAO {

    public static void inserirLoteLog(Connection conn, List<String> mensagensLog) {
        String sql = "INSERT INTO logs_sistema (mensagem, data_registro) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (String mensagem : mensagensLog) {
                ps.setString(1, mensagem);
                ps.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                ps.addBatch(); // guarda o comando para executar tudo de uma vez
            }

            int[] resultados = ps.executeBatch();
            System.out.println("Lote executado! Registros inseridos: " + resultados.length);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir lote de logs: " + e.getMessage());
        }
    }
}
