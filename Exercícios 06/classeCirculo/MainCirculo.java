import java.util.Scanner;

public class MainCirculo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o raio do círculo: ");
        double raioDigitado = sc.nextDouble();

        Circulo meuCirculo = new Circulo();
        meuCirculo.raio = raioDigitado;

        double area = meuCirculo.calcularArea();
        double perimetro = meuCirculo.calcularPerimetro();

        System.out.printf("Área: %.2f%n", area);
        System.out.printf("Perímetro: %.2f%n", perimetro);

        sc.close();
    }
}