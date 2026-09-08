
import java.util.Scanner;

public class mediaSimples {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double primeiraNota = sc.nextDouble();
        System.out.print("Digite a segunda nota: ");
        double segundaNota = sc.nextDouble();
        System.out.print("Digite a terceira nota: ");
        double terceiraNota = sc.nextDouble();
        sc.nextLine();

        double calculoDamedia = (primeiraNota + segundaNota + terceiraNota)/3;

        System.out.println("Sua média aritimética é: " + calculoDamedia);
        sc.close();
    
    }
}