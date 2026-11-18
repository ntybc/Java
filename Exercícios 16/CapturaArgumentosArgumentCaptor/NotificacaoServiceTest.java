// Exercício 4 - ArgumentCaptor: "pega" os valores que foram passados para o mock
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NotificacaoServiceTest {

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private NotificacaoService service;

    // um captor para cada parâmetro do método enviar
    @Captor
    private ArgumentCaptor<String> destinatarioCaptor;

    @Captor
    private ArgumentCaptor<String> assuntoCaptor;

    @Captor
    private ArgumentCaptor<String> corpoCaptor;

    @Test
    void deveMontarMensagemCorretaEEnviarEmail() {
        service.notificarBoasVindas("Nathalia", "nathalia@teste.com");

        // verifica a chamada e captura os argumentos usados
        verify(emailSender).enviar(
                destinatarioCaptor.capture(),
                assuntoCaptor.capture(),
                corpoCaptor.capture());

        assertEquals("nathalia@teste.com", destinatarioCaptor.getValue());
        assertTrue(assuntoCaptor.getValue().contains("Bem-vindo"));
        assertTrue(corpoCaptor.getValue().contains("Nathalia"));
    }
}
