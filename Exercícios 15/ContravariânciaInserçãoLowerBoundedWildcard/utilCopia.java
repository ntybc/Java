import java.util.List;

public class UtilCopia {
    public static <T> void copiarElementos(List<? extends T> origem,
                                           List<? super T> destino) {
        for (T elemento : origem) {   // origem produz (extends)
            destino.add(elemento);    // destino consome (super)
        }
    }
}