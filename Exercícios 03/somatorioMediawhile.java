import java.util.Scanner;

public class somatorioMediawhile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int soma = 0;
        int contador = 0;

        System.out.print("Digite um numero: ");
        int numero = sc.nextInt();

        while (numero>= 0) {
            soma += numero;
            contador ++;
            
            System.out.print("Digite um numero: ");
            numero = sc.nextInt();

        }

        if (contador>0) {
            double media = (double) soma/contador;

            System.out.println("Quantidade de numeros positivos: " + contador);
            System.out.println("Soma total: " + soma);
            System.out.println("Media: " + media);
        }else{
            System.out.println("Nenhum numero positivo foi digitado.");
        }

        sc.close();
    }
}