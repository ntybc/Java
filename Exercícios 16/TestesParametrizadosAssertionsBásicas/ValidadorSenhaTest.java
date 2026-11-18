// Exercício 1 - Testes parametrizados e assertions básicas
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorSenhaTest {

    private final ValidadorSenha validador = new ValidadorSenha();

    // @ParameterizedTest roda o mesmo teste uma vez para cada valor do @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"SenhaForte1", "Faeterj2026", "JavaPOO3pob"})
    @DisplayName("Deve aceitar senhas com 8+ caracteres, maiúscula e número")
    void deveAceitarSenhasFortes(String senha) {
        assertTrue(validador.isForte(senha));
    }

    // @NullAndEmptySource também testa null e "" (texto vazio)
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Curta1", "semnumeroA", "SEMNUMERO", "12345678", "minuscula1"})
    @DisplayName("Deve recusar senhas nulas, vazias ou fora do padrão")
    void deveRecusarSenhasFracas(String senha) {
        assertFalse(validador.isForte(senha));
    }

    // teste simples (sem parâmetro) do caso limite: exatamente 8 caracteres
    @Test
    @DisplayName("Senha com exatamente 8 caracteres válidos deve ser forte")
    void deveAceitarSenhaComOitoCaracteres() {
        assertEquals(true, validador.isForte("Abcdefg1"));
    }
}
