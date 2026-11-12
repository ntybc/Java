import java.util.List;

public class Exercicio4 {

    public static List<String> processarLista(List<String> lista, TransformadorTexto regra) {
        return lista.stream()
            .map(regra::transformar)
            .toList();
    }

    public static void main(String[] args) {
        List<String> palavras = List.of("java", "stream", "lambda");

        
        List<String> invertidas = processarLista(palavras,
            s -> new StringBuilder(s).reverse().toString());

       
        List<String> entreColchetes = processarLista(palavras,
            s -> "[" + s + "]");

        
        List<String> maiusculas = processarLista(palavras, String::toUpperCase);

        System.out.println("Invertidas:      " + invertidas);
        System.out.println("Entre colchetes: " + entreColchetes);
        System.out.println("Maiúsculas:      " + maiusculas);
    }
}