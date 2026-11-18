import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {

    public static void atualizarSalario(Connection conn, Long id, double novoSalario) {
        String sql = "UPDATE funcionarios SET salario = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, novoSalario);
            ps.setLong(2, id);

            int linhas = ps.executeUpdate();
            if (linhas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Salário atualizado! Linhas afetadas: " + linhas);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar salário: " + e.getMessage());
        }
    }

    public static void deletarPorId(Connection conn, Long id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);

            int linhas = ps.executeUpdate();
            if (linhas == 0) {
                System.out.println("Nenhum registro encontrado com o ID informado.");
            } else {
                System.out.println("Funcionário deletado! Linhas afetadas: " + linhas);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionário: " + e.getMessage());
        }
    }
}
