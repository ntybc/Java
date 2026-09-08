import java.util.ArrayList;
import java.util.Scanner;

public class armazenamentoLeituraInversa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o numero: ");
            numeros.add(sc.nextInt());
        }

        System.out.println("Ordem inversa:");
        for (int i = numeros.size() - 1; i >= 0; i--) {
            System.out.print(numeros.get(i));

            if (i > 0) {
            System.out.print(" ");
            }
        }

        sc.close();
    }
}
/*int[] numeros = new int [5];

        for(int i = 0; i<numeros.length; i++){
            System.out.print("Digite um numero:  ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Ordem inversa: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.print(numeros[i]);
            
            if (i > 0) {
            System.out.print(" ");
            }
        }*/