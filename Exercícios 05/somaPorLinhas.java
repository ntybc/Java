import java.util.Scanner;

public class somaPorLinhas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[4][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        int[] somaLinhas = new int[4];

        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;

            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }

            somaLinhas[i] = soma;
        }

        System.out.println("Soma de cada linha:");
        for (int i = 0; i < somaLinhas.length; i++) {
            System.out.println("Linha " + i + ": " + somaLinhas[i]);
        }

        sc.close();
    }
}
