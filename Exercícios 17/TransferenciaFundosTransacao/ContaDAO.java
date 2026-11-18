import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

    public static void transferirFundos(Connection conn, Long idOrigem, Long idDestino, double valor) {
        String sqlDebito = "UPDATE contas SET saldo = saldo - ? WHERE id = ?";
        String sqlCredito = "UPDATE contas SET saldo = saldo + ? WHERE id = ?";

        try {
            conn.setAutoCommit(false); // começa a transação

            // 1) debita da conta de origem
            try (PreparedStatement psDebito = conn.prepareStatement(sqlDebito)) {
                psDebito.setDouble(1, valor);
                psDebito.setLong(2, idOrigem);
                int linhas = psDebito.executeUpdate();
                if (linhas == 0) {
                    throw new IllegalStateException("Conta de origem não encontrada.");
                }
            }

            // 2) verifica se ficou saldo insuficiente (erro de negócio)
            if (consultarSaldo(conn, idOrigem) < 0) {
                throw new IllegalStateException("Saldo insuficiente na conta de origem.");
            }

            // 3) credita na conta de destino
            try (PreparedStatement psCredito = conn.prepareStatement(sqlCredito)) {
                psCredito.setDouble(1, valor);
                psCredito.setLong(2, idDestino);
                int linhas = psCredito.executeUpdate();
                if (linhas == 0) {
                    throw new IllegalStateException("Conta de destino não encontrada.");
                }
            }

            conn.commit();
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso! (commit)");

        } catch (SQLException | IllegalStateException e) {
            System.out.println("Transferência cancelada: " + e.getMessage());
            try {
                conn.rollback();
                System.out.println("Rollback executado.");
            } catch (SQLException ex) {
                System.out.println("Erro ao fazer rollback: " + ex.getMessage());
            }
        } finally {
            try {
                conn.setAutoCommit(true); // volta ao normal
            } catch (SQLException e) {
                System.out.println("Erro ao restaurar autocommit: " + e.getMessage());
            }
        }
    }

    public static double consultarSaldo(Connection conn, Long id) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT saldo FROM contas WHERE id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("saldo");
                }
                throw new SQLException("Conta " + id + " não existe.");
            }
        }
    }
}
