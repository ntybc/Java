// Exercício 5 - doThrow (simular falha) e never (garantir que algo não aconteceu)
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPagamentoServiceTest {

    @Mock
    private GatewayPagamento gateway;

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private ProcessadorPagamentoService service;

    @Test
    void deveMarcarComoPagoEAtualizarQuandoGatewayAprova() {
        Pedido pedido = new Pedido(350.0);

        service.processar(pedido);

        assertEquals(StatusPedido.PAGO, pedido.getStatus());
        verify(gateway, times(1)).cobrar(350.0);
        verify(repository, times(1)).atualizar(pedido);
    }

    @Test
    void naoDeveAtualizarPedidoQuandoGatewayRecusa() {
        Pedido pedido = new Pedido(350.0);
        // doThrow é usado em métodos void: simula o gateway recusando o cartão
        doThrow(new PagamentoRecusadoException("Cartão negado"))
                .when(gateway).cobrar(anyDouble());

        assertThrows(PagamentoRecusadoException.class, () -> service.processar(pedido));

        // o pedido continua PENDENTE e o repositório nunca foi chamado
        assertEquals(StatusPedido.PENDENTE, pedido.getStatus());
        verify(repository, never()).atualizar(any(Pedido.class));
    }
}
