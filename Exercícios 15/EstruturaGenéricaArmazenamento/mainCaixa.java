public class MainCaixa {
    public static void main(String[] args) {
        Caixa<Integer> caixaInt = new Caixa<>();
        caixaInt.guardar(42);
        int n = caixaInt.recuperar();          // sem casting
        System.out.println("Integer: " + n);

        Caixa<String> caixaStr = new Caixa<>();
        caixaStr.guardar("Olá, generics!");
        String s = caixaStr.recuperar();       // sem casting
        System.out.println("String: " + s);

        Caixa<Produto> caixaProd = new Caixa<>();
        caixaProd.guardar(new Produto("Notebook", 3500.0));
        Produto p = caixaProd.recuperar();     // sem casting
        System.out.println("Produto: " + p);

        System.out.println("Vazia? " + caixaProd.isVazia());
        caixaProd.limpar();
        System.out.println("Vazia após limpar? " + caixaProd.isVazia());

        // caixaInt.guardar("texto"); // erro de compilação: tipagem estática
    }
}