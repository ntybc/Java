import java.util.ArrayList;
import java.util.Scanner;

public class separacaoParesImpares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> original = new ArrayList<>();
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número: ");
            int numero = sc.nextInt();
            original.add(numero);

            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }

        System.out.println("Números pares:");
        for (int i = 0; i < pares.size(); i++) {
            System.out.print(pares.get(i) + " ");
        }
        System.out.println();

        System.out.println("Números ímpares:");
        for (int i = 0; i < impares.size(); i++) {
            System.out.print(impares.get(i) + " ");
        }
        System.out.println();

        sc.close();
    }
}