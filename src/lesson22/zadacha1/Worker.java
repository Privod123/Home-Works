package lesson22.zadacha1;

/**
 * Created by Hello on 16.12.2018.
 */
public class Worker implements Runnable{

    private Storage storage;

    public Worker(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
       storage.find();
    }
}
