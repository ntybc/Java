package br.edu.universidade.catalogo;

import br.edu.universidade.catalogo.dominio.Produto;
import br.edu.universidade.catalogo.service.CatalogoService;

public class CatalogoApp {

    public static void main(String[] args) {
        CatalogoService service = new CatalogoService();

        System.out.println("=== 1. Cadastro de produtos (fora de ordem de preço) ===");
        service.cadastrar(new Produto("P003", "Monitor 27\" 144Hz", 1899.90, 8));
        service.cadastrar(new Produto("P001", "Teclado Mecânico RGB", 349.90, 25));
        service.cadastrar(new Produto("P004", "Headset Gamer 7.1", 459.00, 15));
        service.cadastrar(new Produto("P002", "Mouse Sem Fio Ergonômico", 129.50, 40));

        System.out.printf("Total de produtos: %d%n%n", service.getTotalProdutos());
        service.listarTodos().forEach(System.out::println);

        System.out.println("\n=== 2. Exclusão de um produto intermediário (P003) ===");
        boolean removido = service.excluirPorCodigo("P003");
        System.out.println("Produto P003 removido? " + removido);
        System.out.printf("Total restante: %d%n%n", service.getTotalProdutos());
        service.listarTodos().forEach(System.out::println);

        System.out.println("\n=== 3. Ordenação crescente por preço ===");
        service.ordenarPorPreco();
        service.listarTodos().forEach(System.out::println);

        System.out.println("\n=== Verificação final (sem buracos nos índices) ===");
        for (int i = 0; i < service.getTotalProdutos(); i++) {
            System.out.println("Índice " + i + " → " + service.obterPorPosicao(i));
        }
    }
}