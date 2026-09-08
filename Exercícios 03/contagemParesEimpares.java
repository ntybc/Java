import java.util.Scanner;

public class contagemParesEimpares {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int totalPares = 0;
        int totalImpares = 0;

        System.out.println("Digite o início do intervalo: ");
        int inicioInter = sc.nextInt();

        System.out.println("Digite o fim do intervalo: ");
        int fimInter = sc.nextInt();

        for(int i = inicioInter ; i <= fimInter ; i++){
            if (i % 2 == 0) {
                totalPares++;
            }else { 
                totalImpares++;
            }
        }

        System.out.println("Quantidade de números pares: " + totalPares);
        System.out.println("Quantidade de números ímpares: " + totalImpares);

        sc.close();

    }
}
