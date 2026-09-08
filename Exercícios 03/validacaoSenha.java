import java.util.Scanner;

public class validacaoSenha {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int senhaCerta = 1234;
        int senha;
        do {
            System.out.println("Digite sua senha: ");
            senha = sc.nextInt();

            if (senha != senhaCerta) {
                
                System.out.println("Senha incorreta!");
            }

        } while (senha != senhaCerta);

        System.out.println("Senha correta!");
        
        sc.close();
    }
}
