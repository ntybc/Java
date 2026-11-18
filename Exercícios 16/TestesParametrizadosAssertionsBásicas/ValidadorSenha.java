// Exercício 1 - Código de produção
// Uma senha é considerada forte quando tem pelo menos 8 caracteres,
// pelo menos uma letra maiúscula e pelo menos um número.
public class ValidadorSenha {

    public boolean isForte(String senha) {
        // senha nula ou curta demais já é fraca
        if (senha == null || senha.length() < 8) {
            return false;
        }

        boolean temMaiuscula = false;
        boolean temNumero = false;

        // percorre cada caractere da senha procurando maiúscula e número
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                temMaiuscula = true;
            }
            if (Character.isDigit(c)) {
                temNumero = true;
            }
        }

        return temMaiuscula && temNumero;
    }
}
