import java.util.ArrayList;
import java.util.List;

public class mainParque {

    public static double calcularTotalImpostos(List<Tributavel> itensTributaveis) {
        double total = 0;
        for (Tributavel item : itensTributaveis) {
            total += item.calcularTributo();
        }
        return total;
    }

    public static void main(String[] args) {
        Eletronico tv = new Eletronico(101, 2000);
        Eletronico fone = new Eletronico(102, 300);
        Alimento pipoca = new Alimento(201, 15);

        System.out.printf("Item não tributável: código %d, preço R$ %.2f%n", pipoca.getCodigo(), pipoca.getPrecoBase());

        List<Tributavel> itensTributaveis = new ArrayList<>();
        itensTributaveis.add(tv);
        itensTributaveis.add(fone);
        // pipoca não entra: Alimento não implementa Tributavel

        System.out.printf("Tributo da TV (código %d): R$ %.2f%n", tv.getCodigo(), tv.calcularTributo());
        System.out.printf("Tributo do fone (código %d): R$ %.2f%n", fone.getCodigo(), fone.calcularTributo());
        System.out.printf("Total de impostos: R$ %.2f%n", calcularTotalImpostos(itensTributaveis));
    }
}