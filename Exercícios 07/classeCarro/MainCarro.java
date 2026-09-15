package classeCarro;

public class MainCarro {
    public static void main(String[] args) {
        Carro carro = new Carro("Civic", 2022);

        System.out.println("=== Carro recém-criado ===");
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Ano: " + carro.getAno());
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Em movimento? " + carro.isEmMovimento());

        System.out.println("\n=== Acelerando ===");
        carro.acelerar(40);
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Em movimento? " + carro.isEmMovimento());

        System.out.println("\n=== Freando parcialmente ===");
        carro.frear(15);
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Em movimento? " + carro.isEmMovimento());

        System.out.println("\n=== Freando além do necessário (não pode ficar negativo) ===");
        carro.frear(100);
        System.out.println("Velocidade: " + carro.getVelocidadeAtual());
        System.out.println("Em movimento? " + carro.isEmMovimento());

        System.out.println("\n=== Testando setModelo ===");
        carro.setModelo("Civic Touring");
        System.out.println("Novo modelo: " + carro.getModelo());
    }
}