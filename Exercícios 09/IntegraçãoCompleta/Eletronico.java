public class Eletronico extends Item implements Tributavel {
    private static final double TAXA_TRIBUTO = 15.0; // em %

    public Eletronico(int codigo, double precoBase) {
        super(codigo, precoBase);
    }

    @Override
    public double calcularTributo() {
        return getPrecoBase() * TAXA_TRIBUTO / 100;
    }
}