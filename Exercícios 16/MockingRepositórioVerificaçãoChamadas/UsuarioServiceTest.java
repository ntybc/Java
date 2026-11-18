// Exercício 3 - @Mock, when/thenReturn e verify
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // liga o Mockito no JUnit 5
public class UsuarioServiceTest {

    @Mock // cria um repositório "falso"
    private UsuarioRepository repository;

    @InjectMocks // cria o service já recebendo o mock no construtor
    private UsuarioService service;

    @Test
    void deveAtualizarEmailESalvarUsuario() {
        Usuario usuario = new Usuario(1L, "antigo@teste.com");
        // ensina o mock: quando buscarPorId(1) for chamado, devolve esse usuário
        when(repository.buscarPorId(1L)).thenReturn(Optional.of(usuario));

        service.atualizarEmail(1L, "novo@teste.com");

        assertEquals("novo@teste.com", usuario.getEmail());
        // verify confere se o service chamou os métodos do repositório
        verify(repository, times(1)).buscarPorId(1L);
        verify(repository, times(1)).salvar(usuario);
    }

    @Test
    void naoDeveSalvarQuandoUsuarioNaoExiste() {
        when(repository.buscarPorId(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> service.atualizarEmail(99L, "x@teste.com"));

        // never() garante que salvar NÃO foi chamado
        verify(repository, never()).salvar(any(Usuario.class));
    }
}
