public class mainFuncionario {

    public static void main(String[] args) {

        funcionario func = new funcionario();
        func.nome = "Carlos Silva";
        func.cargo = "Analista de Sistemas";
        func.salarioBruto = 3000;

        System.out.println("=== Antes do aumento ===");
        System.out.println("Nome: " + func.nome);
        System.out.println("Cargo: " + func.cargo);
        System.out.println("Salário bruto: " + func.salarioBruto);

        func.aplicarAumento(10);

        System.out.println("\n=== Depois do aumento de 10% ===");
        System.out.println("Salário bruto: " + func.salarioBruto);

        double salarioLiquido = func.calcularSalarioLiquido(250);
        System.out.println("Salário líquido (desconto de 250): " + salarioLiquido);
    }
}