package downloadsPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainDownloads {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<String>> futuros = new ArrayList<>();

        try {
            for (int id = 1; id <= 6; id++) {
                futuros.add(pool.submit(new TarefaDownload(id)));
            }

            for (Future<String> futuro : futuros) {
                System.out.println(futuro.get()); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Erro em uma tarefa: " + e.getCause());
        } finally {
            pool.shutdown();
        }
    }
}