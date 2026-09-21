public class mainFolhaPagamento {
    public static void main(String[] args) {
        Funcionario[] equipe = new Funcionario[4];
        equipe[0] = new Gerente("Ana", 5000, 2000);
        equipe[1] = new Vendedor("Bruno", 2000, 10000, 5);
        equipe[2] = new Vendedor("Diego", 2200, 20000, 3);
        equipe[3] = new Funcionario("Carla", 1800);

        double folhaTotal = 0;

        for (Funcionario f : equipe) {
            double salario = f.calcularSalario(); // ligação dinâmica
            System.out.printf("%-6s R$ %.2f%n", f.getNome(), salario);
            folhaTotal += salario;
        }

        System.out.printf("Folha total: R$ %.2f%n", folhaTotal);
    }
}