package dominio;

public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(int id, String nome, int idade, double altura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void listarPessoa() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Altura: " + altura);
    }

    public String toCSV() {
        return id + ";" + nome + ";" + idade + ";" + altura;
    }
}