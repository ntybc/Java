import java.util.Scanner;

public class exr05 {
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite os segundos: ");
        int segundos = sc.nextInt();

        int horas = segundos / 3600 ;
        int segundos01 = segundos % 3600 ; 
        int minutos = segundos01 / 60 ; 
        int segundosFinais = segundos01 % 60 ;  

        System.out.println( horas + " Hora(s)"+ minutos + " Minuto(s)"+ segundosFinais + " Segundo(s)" );
        sc.close();



    }
}
    