// Exercício 3 - Código de produção que depende do repositório
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void atualizarEmail(Long id, String novoEmail) {
        // busca o usuário; se não existir, lança exceção
        Usuario usuario = repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuario.setEmail(novoEmail);
        repository.salvar(usuario);
    }
}
