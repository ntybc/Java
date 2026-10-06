public class idadeInvalida {

    static class IdadeInvalidaException extends RuntimeException {
        public IdadeInvalidaException(String mensagem) {
            super(mensagem);
        }
    }

    static class Eleitor {
        private String nome;
        private int idade;

        public void cadastrar(String nome, int idade) {
            if (idade < 0 || idade > 130) {
                throw new IdadeInvalidaException("Idade invalida para cadastro: " + idade + ". A idade deve estar entre 0 e 130 anos.");
            }
            this.nome = nome;
            this.idade = idade;
            System.out.println("Eleitor " + this.nome + " cadastrado com sucesso com " + this.idade + " anos.");
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }
    }

    public static void main(String[] args) {
        Eleitor eleitor = new Eleitor();

        System.out.println("=== CADASTRO DE ELEITORES ===");

        try {
            System.out.println("\nTentando cadastrar: Joao, 25 anos");
            eleitor.cadastrar("Joao", 25);
        } catch (IdadeInvalidaException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando cadastrar: Maria, -5 anos");
            eleitor.cadastrar("Maria", -5);
        } catch (IdadeInvalidaException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        try {
            System.out.println("\nTentando cadastrar: Carlos, 140 anos");
            eleitor.cadastrar("Carlos", 140);
        } catch (IdadeInvalidaException e) {
            System.out.println("Excecao capturada: " + e.getMessage());
        }

        System.out.println("\nPrograma finalizado com sucesso.");
    }
}