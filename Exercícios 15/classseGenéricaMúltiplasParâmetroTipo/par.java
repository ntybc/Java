import java.util.Objects;

public final class Par<K, V> {
    private final K chave;
    private final V valor;

    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "[Chave: " + chave + ", Valor: " + valor + "]";
    }

    public static <K, V> boolean saoIguais(Par<K, V> p1, Par<K, V> p2) {
        return Objects.equals(p1.getChave(), p2.getChave())
            && Objects.equals(p1.getValor(), p2.getValor());
    }
}