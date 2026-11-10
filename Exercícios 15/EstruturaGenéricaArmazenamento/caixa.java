public class Caixa<T> {
    private T conteudo;

    public void guardar(T elemento) {
        this.conteudo = elemento;
    }

    public T recuperar() {
        return conteudo;
    }

    public boolean isVazia() {
        return conteudo == null;
    }

    public void limpar() {
        conteudo = null;
    }
}