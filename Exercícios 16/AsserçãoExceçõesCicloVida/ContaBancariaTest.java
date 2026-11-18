// Exercício 2 - assertThrows e ciclo de vida com @BeforeEach
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaBancariaTest {

    private ContaBancaria conta;

    // @BeforeEach roda ANTES de cada teste: cada teste começa com uma conta nova de R$ 500
    @BeforeEach
    void prepararConta() {
        conta = new ContaBancaria(500.0);
    }

    @Test
    @DisplayName("Deve sacar e diminuir o saldo quando há dinheiro suficiente")
    void deveSacarComSucesso() {
        conta.sacar(200.0);
        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar SaldoInsuficienteException ao sacar mais que o saldo")
    void deveLancarExcecaoQuandoSaldoInsuficiente() {
        // assertThrows verifica se a exceção foi lançada e devolve ela para conferirmos a mensagem
        SaldoInsuficienteException ex = assertThrows(
                SaldoInsuficienteException.class,
                () -> conta.sacar(600.0));

        assertEquals("Saldo insuficiente. Saldo disponível: 500.0", ex.getMessage());
        // o saldo não pode ter mudado
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException para saque zero ou negativo")
    void deveLancarExcecaoQuandoValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(0.0));
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10.0));
    }
}
