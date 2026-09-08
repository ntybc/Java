import java.util.Scanner;

public class salarioComDesconto {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da sua hora de trabalho: ");
        double valorDahora = sc.nextDouble();
        System.out.print("Digite  a quantidade de horas trabalhadas no mês: ");
        double horasTrabalhadas = sc.nextDouble();

        double salarioBruto = valorDahora * horasTrabalhadas ;
        double desconto = salarioBruto * 0.1 ;
        double salarioFinal = salarioBruto - desconto ;
        
        System.out.println("O seu salário bruto é: " + salarioBruto);
        System.out.println("O valor descontado do seu salário foi: " + desconto);
        System.out.println("O seu salário final é: " + salarioFinal);
        sc.close();
    }
}