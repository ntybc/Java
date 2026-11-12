import java.util.Arrays;
import java.util.List;

public class filtragemTransformacao {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList(
            "ana", "carlos", "beatriz", "antonio", "amanda", "bernardo");

        List<String> resultado = nomes.stream()
            .filter(n -> n.toLowerCase().startsWith("a"))   
            .map(String::toUpperCase)                       
            .sorted()                                       
            .toList();                                      
        
        System.out.println(resultado);
        
    }
}