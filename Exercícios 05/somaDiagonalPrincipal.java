import java.util.Scanner;

public class somaDiagonalPrincipal {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] matriz = new double[4][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        double soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }

        System.out.println("Soma da diagonal principal: " + soma);

        sc.close();
    }
}  

