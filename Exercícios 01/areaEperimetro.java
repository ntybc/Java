import java.util.Scanner;

public class areaEperimetro {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da base: ");
        double base = sc.nextDouble();
        System.out.print("Digite o valor da altura: ");
        double altura = sc.nextDouble();
        
        double area = (base * altura);
        double  perimetro = (2  * (base + altura));

        System.out.println("Área: " + area + " Perimetro: " + perimetro);
        sc.close();

        }
}
