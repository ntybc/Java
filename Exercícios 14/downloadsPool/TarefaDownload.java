package downloadsPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class TarefaDownload implements Callable<String> {

    private final int id;

    public TarefaDownload(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        int pausa = ThreadLocalRandom.current().nextInt(500, 1501);
        Thread.sleep(pausa);
        return "Arquivo " + id + " processado pela thread: " + Thread.currentThread().getName();
    }
}