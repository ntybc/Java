import java.util.ArrayList;
import java.util.List;

public class mainContas {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaCorrente("001-C", 1000));
        contas.add(new ContaEmpresarial("002-E", 20000));

        System.out.println("=== Virada de mês ===");
        for (ContaBancaria conta : contas) {
            conta.cobrarTaxaMensal();
            conta.consultarSaldo();
            System.out.println();
        }
    }
}