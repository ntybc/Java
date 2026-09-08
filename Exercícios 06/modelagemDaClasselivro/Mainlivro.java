public class Mainlivro {

    public static void main(String[] args) {

        livro livro1 = new livro();
        livro1.titulo = "O Pequeno Príncipe";
        livro1.autor = "Antoine de Saint-Exupéry";
        livro1.numeroPaginas = 96;

        livro livro2 = new livro();
        livro2.titulo = "Jogos Vorazes";
        livro2.autor = "Suzanne Collins";
        livro2.numeroPaginas = 374;

        System.out.println("=== Livro 1 ===");
        livro1.exibirInformacoes();

        System.out.println("=== Livro 2 ===");
        livro2.exibirInformacoes();
    }
}