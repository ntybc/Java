public abstract class Item {
    private int codigo;
    private double precoBase;

    public Item(int codigo, double precoBase) {
        this.codigo = codigo;
        this.precoBase = precoBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecoBase() {
        return precoBase;
    }
}