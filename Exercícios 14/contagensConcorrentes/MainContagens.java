public class MainContagens {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ContadorCrescente());
        Thread t2 = new Thread(new ContadorRegressivo());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Contagens finalizadas!");
    }
}