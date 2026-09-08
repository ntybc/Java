import java.util.ArrayList;
import java.util.Scanner;

public class maiorMenorPosicoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            numeros.add(sc.nextInt());
        }

        int maior = numeros.get(0);
        int posicaoMaior = 0;

        int menor = numeros.get(0);
        int posicaoMenor = 0;

        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) > maior) {
                maior = numeros.get(i);
                posicaoMaior = i;
            }
            if (numeros.get(i) < menor) {
                menor = numeros.get(i);
                posicaoMenor = i;
            }
        }

        System.out.println("Maior valor: " + maior + " (posição " + posicaoMaior + ")");
        System.out.println("Menor valor: " + menor + " (posição " + posicaoMenor + ")");

        sc.close();
    }
}
/* int[] numeros = new int[10];
        int maior = numeros[0];
        int posicaoMaior = 0;
        int menor = numeros[0];
        int posicaoMenor = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o valor: ");
            numeros[i] = sc.nextInt();
        }
        
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
                posicaoMaior = i;
            }
            if (numeros[i] < menor) {
                menor = numeros[i];
                posicaoMenor = i;
            }
        }

        System.out.println("Maior valor: " + maior + " (posição " + posicaoMaior + ")");
        System.out.println("Menor valor: " + menor + " (posição " + posicaoMenor + ")");
         */