public class Vendedor extends Funcionario {
    private double totalVendas;
    private double comissaoPercentual; // ex.: 5 significa 5%

    public Vendedor(String nome, double salarioBase, double totalVendas, double comissaoPercentual) {
        super(nome, salarioBase);
        this.totalVendas = totalVendas;
        this.comissaoPercentual = comissaoPercentual;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (totalVendas * comissaoPercentual / 100);
    }
}