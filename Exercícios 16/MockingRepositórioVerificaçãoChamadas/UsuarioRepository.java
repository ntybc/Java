// Exercício 3 - Interface do repositório (seria o acesso ao banco).
// No teste ela é substituída por um mock, então não precisa de banco de verdade.
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(Long id);
    void salvar(Usuario usuario);
}
