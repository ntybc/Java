import java.util.ArrayList;
import java.util.List;

public class MainFiguras {
    public static void main(String[] args) {
        List<Quadrado> quadrados = new ArrayList<>();
        quadrados.add(new Quadrado(2));
        quadrados.add(new Quadrado(3));

        List<Circulo> circulos = new ArrayList<>();
        circulos.add(new Circulo(1));

        List<Figura> mistas = new ArrayList<>();
        mistas.add(new Quadrado(4));
        mistas.add(new Circulo(2));

        System.out.printf("Quadrados: %.2f%n", UtilFiguras.somarAreas(quadrados));
        System.out.printf("Círculos:  %.2f%n", UtilFiguras.somarAreas(circulos));
        System.out.printf("Mistas:    %.2f%n", UtilFiguras.somarAreas(mistas));
    }
}