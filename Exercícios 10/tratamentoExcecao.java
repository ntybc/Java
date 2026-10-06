import java.util.InputMismatchException;
import java.util.Scanner;

public class tratamentoExcecao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Digite o primeiro número inteiro: ");
            int dividendo = sc.nextInt();

            System.out.print("Digite o segundo número inteiro: ");
            int divisor = sc.nextInt();

            int resultado = dividendo / divisor; 
            
            System.out.println("Resultado da divisão: " + resultado);

        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível realizar divisão por zero.");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas números inteiros válidos.");

        } finally {
            System.out.println("Operação finalizada.");
            sc.close();
        }
    }
}
