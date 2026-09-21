public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String marca, String modelo, int quantidadePortas) {
        super(marca, modelo); // reaproveita construtor da superclasse
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // reaproveita a impressão de marca/modelo
        System.out.println("Quantidade de portas: " + quantidadePortas);
    }
}