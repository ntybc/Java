import java.util.ArrayList;
import java.util.Scanner;

public class buscaLinear {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o número: ");
            numeros.add(sc.nextInt());
        }

        System.out.print("Digite o número que deseja buscar: ");
        int x = sc.nextInt();

        boolean encontrado = false;
        int posicao = -1;

        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == x) {
                encontrado = true;
                posicao = i;
                break;
            }
        }

        if (encontrado) {
            System.out.println(x + " encontrado na posição " + posicao);
        } else {
            System.out.println(x + " não está presente no vetor.");
        }

        sc.close();
    }
}