public class mainPagamento {

    // recebe qualquer MetodoPagamento, sem saber a implementação concreta
    public static void finalizarCompra(MetodoPagamento metodo, double total) {
        System.out.println(metodo.obterDetalhes());
        metodo.processarPagamento(total);
        System.out.println();
    }

    public static void main(String[] args) {
        MetodoPagamento cartao = new CartaoCredito("**** 4821", 1000);
        MetodoPagamento pix = new Pix("nathalia@email.com");

        finalizarCompra(cartao, 350);
        finalizarCompra(pix, 120);
        finalizarCompra(cartao, 800); // deve ser recusado: só restam 650 de limite
    }
}