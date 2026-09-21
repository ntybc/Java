public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo); // reaproveita construtor da superclasse
        this.cilindradas = cilindradas;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes(); // reaproveita a impressão de marca/modelo
        System.out.println("Cilindradas: " + cilindradas);
    }
}