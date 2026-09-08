import java.util.Scanner;

public class tabuadaNumero {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = sc.nextInt();

        for(int i = 1; i<=10; i++){
            System.err.println(numero +" x " + i + " = "+ (numero * i));
        }

       sc.close();
     
    }
}
