public class mainFormas {
    public static void main(String[] args) {
        Forma[] formas = {
            new Retangulo("Azul", 5, 3),
            new Circulo("Vermelho", 2)
        };

        for (Forma f : formas) {
            f.exibirCor();
            System.out.printf("Área: %.2f%n%n", f.calcularArea());
        }
    }
}