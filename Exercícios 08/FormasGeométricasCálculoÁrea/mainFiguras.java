import java.util.ArrayList;

public class mainFiguras {
    public static void main(String[] args) {
        ArrayList<FiguraGeometrica> figuras = new ArrayList<>();
        figuras.add(new Quadrado(4));
        figuras.add(new Retangulo(5, 3));
        figuras.add(new Circulo(2));
        figuras.add(new Circulo(1.5));

        for (FiguraGeometrica f : figuras) {
            System.out.printf("%-10s área: %.2f%n", f.getClass().getSimpleName(), f.calcularArea());
        }
    }
}