package classeRetangulo;

public class MainRetangulo {
    public static void main(String[] args) {
        // Retângulo com valores válidos
        Retangulo retanguloA = new Retangulo(5.0, 3.0);

        System.out.println("=== Retângulo A ===");
        System.out.println("Largura: " + retanguloA.getLargura());
        System.out.println("Altura: " + retanguloA.getAltura());
        System.out.println("Área: " + retanguloA.calcularArea());
        System.out.println("Perímetro: " + retanguloA.calcularPerimetro());

        // Retângulo com valores inválidos (deve cair no padrão 1.0)
        System.out.println("\n=== Retângulo B (valores inválidos) ===");
        Retangulo retanguloB = new Retangulo(-4.0, 0.0);
        System.out.println("Largura: " + retanguloB.getLargura());
        System.out.println("Altura: " + retanguloB.getAltura());
        System.out.println("Área: " + retanguloB.calcularArea());
        System.out.println("Perímetro: " + retanguloB.calcularPerimetro());

        // Testando setter diretamente depois da criação
        System.out.println("\n=== Teste de setter pós-criação ===");
        retanguloA.setLargura(-10.0);
        System.out.println("Largura após tentativa inválida: " + retanguloA.getLargura());
    }
}
