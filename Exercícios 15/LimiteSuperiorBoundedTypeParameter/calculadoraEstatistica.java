import java.util.ArrayList;
import java.util.List;

public class CalculadoraEstatistica<T extends Number> {
    private List<T> numeros = new ArrayList<>();

    public void adicionar(T numero) {
        numeros.add(numero);
    }

    public double calcularMedia() {
        if (numeros.isEmpty()) return 0.0;
        double soma = 0;
        for (T n : numeros) {
            soma += n.doubleValue();
        }
        return soma / numeros.size();
    }

    public double calcularMaior() {
        if (numeros.isEmpty()) {
            throw new IllegalStateException("Lista vazia");
        }
        double maior = numeros.get(0).doubleValue();
        for (T n : numeros) {
            if (n.doubleValue() > maior) {
                maior = n.doubleValue();
            }
        }
        return maior;
    }
}