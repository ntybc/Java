public class MainPar {
    public static void main(String[] args) {
        Par<Integer, String> p1 = new Par<>(1, "Ativo");
        Par<Integer, String> p2 = new Par<>(1, "Ativo");
        Par<Integer, String> p3 = new Par<>(2, "Inativo");

        System.out.println(p1);
        System.out.println("p1 == p2? " + Par.saoIguais(p1, p2)); // true
        System.out.println("p1 == p3? " + Par.saoIguais(p1, p3)); // false
    }
}