import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexao()) {
            Conexao.criarTabelas(conn);
            mostrarSaldos(conn, "Saldos iniciais");

            System.out.println("\n=== Transferência válida: R$ 200 da conta 1 para a 2 ===");
            ContaDAO.transferirFundos(conn, 1L, 2L, 200.00);
            mostrarSaldos(conn, "Saldos depois");

            System.out.println("\n=== Saldo insuficiente: R$ 5000 da conta 1 para a 2 ===");
            ContaDAO.transferirFundos(conn, 1L, 2L, 5000.00);
            mostrarSaldos(conn, "Saldos depois (devem estar iguais, pois houve rollback)");

            System.out.println("\n=== Conta de destino inexistente: R$ 100 da conta 1 para a 99 ===");
            ContaDAO.transferirFundos(conn, 1L, 99L, 100.00);
            mostrarSaldos(conn, "Saldos depois (débito desfeito pelo rollback)");

            System.out.println("\nAutoCommit restaurado? " + conn.getAutoCommit());
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    private static void mostrarSaldos(Connection conn, String titulo) throws SQLException {
        System.out.println("--- " + titulo + " ---");
        System.out.println("Conta 1 (Nathalia): R$ " + ContaDAO.consultarSaldo(conn, 1L));
        System.out.println("Conta 2 (Joao):     R$ " + ContaDAO.consultarSaldo(conn, 2L));
    }
}
