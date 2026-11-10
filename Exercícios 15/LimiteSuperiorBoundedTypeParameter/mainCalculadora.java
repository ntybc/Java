public class MainCalculadora {
    public static void main(String[] args) {
        CalculadoraEstatistica<Integer> ci = new CalculadoraEstatistica<>();
        ci.adicionar(10);
        ci.adicionar(20);
        ci.adicionar(30);
        System.out.println("Integer -> média: " + ci.calcularMedia()
                + " | maior: " + ci.calcularMaior());

        CalculadoraEstatistica<Double> cd = new CalculadoraEstatistica<>();
        cd.adicionar(1.5);
        cd.adicionar(2.5);
        cd.adicionar(9.0);
        System.out.println("Double -> média: " + cd.calcularMedia()
                + " | maior: " + cd.calcularMaior());

        // Descomente para ver o erro de compilação:
        // CalculadoraEstatistica<String> cs = new CalculadoraEstatistica<>();
        // erro: type argument String is not within bounds of type-variable T
    }
}