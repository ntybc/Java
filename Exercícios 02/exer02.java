import java.util.Scanner;

public class exer02 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         System.out.print("Digite seu ano de nascimento: ");
         int anoNascimento = sc.nextInt();

         System.out.print("Digite o ano atual: ");
         int anoAtual = sc.nextInt();

         int idade = anoAtual - anoNascimento;

         if(idade >= 18){
            System.out.print("Com "+ idade +" anos você é maior de idade!");
         } else {
            System.out.print("Com "+ idade +" anos você ainda não é maior de idade.");
         }

         sc.close();

    }

}
