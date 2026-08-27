import java.util.Scanner;

public class exer05 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor de A: ");
        double a = sc.nextDouble();
        System.out.print("Digite o valor de B: ");
        double b = sc.nextDouble();
        System.out.print("Digite o valor de C: ");
        double c = sc.nextDouble();

         if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Os valores podem formar um triângulo.");
            
            // Verificando o tipo de triângulo
            if (a == b && b == c) {
                System.out.println("É um triângulo equilátero.");
            } else if (a == b || a == c || b == c) {
                System.out.println("É um triângulo isósceles.");
            } else {
                System.out.println("É um triângulo escaleno.");
            }
        } else {
            System.out.println("Os valores não podem formar um triângulo.");
        }

        sc.close();

    }
}
