public class mainVeiculo {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 4);
        Moto moto = new Moto("Honda", "CB 500", 500);

        System.out.println("=== Carro ===");
        carro.exibirDetalhes();

        System.out.println();

        System.out.println("=== Moto ===");
        moto.exibirDetalhes();
    }
}