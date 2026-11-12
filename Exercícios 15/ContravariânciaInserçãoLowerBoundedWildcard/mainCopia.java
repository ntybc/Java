import java.util.ArrayList;
import java.util.List;

public class MainCopia {
    public static void main(String[] args) {
        List<Integer> inteiros = new ArrayList<>(List.of(1, 2, 3));

        List<Number> numeros = new ArrayList<>();
        UtilCopia.copiarElementos(inteiros, numeros);
        System.out.println("Number: " + numeros);

        List<Object> objetos = new ArrayList<>();
        UtilCopia.copiarElementos(inteiros, objetos);
        System.out.println("Object: " + objetos);
    }
}