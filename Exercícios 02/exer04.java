import java.util.Scanner;

public class exer04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         System.out.print("Digite o primeiro número: ");
            int num1 = sc.nextInt();
         System.out.print("Digite o segundo número: ");
            int num2 = sc.nextInt();
         System.out.print("Digite o terceiro número: ");
            int num3 = sc.nextInt();
        
       

        if (num1>num2 && num1>num3) {
            System.out.print("O primeiro número é o maior número: "+ num1);
        } else if (num2 > num1 && num2>num3) {
            System.out.print("O segundo número é o maior número: " + num2);
        } else {
            System.out.print("O terceiro número é o maior número: " + num3);
        }
         sc.close();
    }
}
/*  System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();
        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        int maior = num1;
        if (num2 > maior) {
            maior = num2;
        }
        if (num3 > maior) {
            maior = num3;
        }
        sc.close();
        System.out.println("O maior número é: " + maior);*/