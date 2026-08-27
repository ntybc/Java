import java.util.Scanner;

public class exer03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double primeiraNota = sc.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double segundaNota = sc.nextDouble();

        double media = (primeiraNota + segundaNota)/2 ;

        if (media >= 7.0) {
            System.out.print("Parabéns! Você foi aprovado!");
            
        } else if (media >= 5.0) {

            System.out.print("Você está em recuperação.");

        } else {

            System.out.print("Você está reprovado.");
        }
        sc.close();
    }
}
