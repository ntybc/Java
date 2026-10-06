import java.util.InputMismatchException;
import java.util.Scanner;

public class conversorVetor {

    public static void main(String[] args) {
        String[] valores = {"10", "25", "abc", "50"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Conteúdo do vetor: [ \"10\", \"25\", \"abc\", \"50\" ]");
        System.out.print("Digite o índice que deseja acessar (0 a 3): ");

        try {
            int indice = sc.nextInt();

            String elemento = valores[indice];
            System.out.println("Texto recuperado na posição [" + indice + "]: \"" + elemento + "\"");

            int numero = Integer.parseInt(elemento);

            System.out.println("Conversão bem-sucedida! Número inteiro resultante: " + numero);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: O índice informado não existe no vetor. Digite uma posição de 0 a " + (valores.length - 1) + ".");

        } catch (NumberFormatException e) {
            System.out.println("Erro: O valor encontrado não é um número inteiro válido.");

        } catch (InputMismatchException e) {
            System.out.println("Erro: O índice precisa ser um número inteiro.");

        } finally {
            System.out.println("Operação finalizada.");
            sc.close();
        }
    }
}