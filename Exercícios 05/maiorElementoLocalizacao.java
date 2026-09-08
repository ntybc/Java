import java.util.Scanner;

public class maiorElementoLocalizacao {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[3][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Digite o valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        int maior = matriz[0][0];
        int linhaMaior = 0;
        int colunaMaior = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                    linhaMaior = i;
                    colunaMaior = j;
                }
            }
        }

        System.out.println("Maior valor: " + maior);
        System.out.println("Localizado na linha " + linhaMaior + ", coluna " + colunaMaior);

        sc.close();
    }
}
