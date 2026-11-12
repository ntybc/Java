import java.util.List;

public class UtilFiguras {
    public static double somarAreas(List<? extends Figura> listaFiguras) {
        double total = 0;
        for (Figura f : listaFiguras) {      // leitura segura
            total += f.calcularArea();
        }
        // listaFiguras.add(new Quadrado(2)); // ERRO de compilação: só leitura
        return total;
    }
}