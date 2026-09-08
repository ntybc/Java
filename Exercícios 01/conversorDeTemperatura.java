import java.util.Scanner;

public class conversorDeTemperatura {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a temperatura em Celsius: ");
        double cel = sc.nextDouble();

               double F = (cel * 1.8) + 32 ;
 
        System.out.println("A temperatura inserida em Fahrenheit é: " + F);
        sc.close();
    }
}
