import java.util.ArrayList;
import java.util.Scanner;

public class mediaAlunosAcima {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Double> notas = new ArrayList<>();
        double soma = 0;

        for (int i = 0; i < 8; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            double nota = sc.nextDouble();
            notas.add(nota);
            soma += nota;
        }

        double media = soma / notas.size();

        System.out.println("Média da turma: " + media);

        System.out.println("Notas acima da média:");
        for (int i = 0; i < notas.size(); i++) {
            if (notas.get(i) > media) {
                System.out.println("Aluno " + (i + 1) + ": " + notas.get(i));
            }
        }

        sc.close();
    }
}
/*double[] notas = new double[8];
        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota do aluno " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            soma += notas[i];
        }

        double media = soma / notas.length;

        System.out.println("Média da turma: " + media);

        System.out.println("Notas acima da média:");
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.println("Aluno " + (i + 1) + ": " + notas[i]);
            }
        }
 */