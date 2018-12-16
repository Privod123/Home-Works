package lesson22.zadacha1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Hello on 16.12.2018.
 */
public class FindTopWord {

    private BlockingQueue<String> word;
    private BlockingQueue<Map<String,Integer>> commonWord;
    private  List<Thread> listTread = new ArrayList<>();


    public void start(){
        File inputFile = new File("src\\lesson22\\zadacha1\\zad2.txt");
        int countWorker = Runtime.getRuntime().availableProcessors(); // определяем сколько потоков запуститься на данной машине
        ReadFile read = new ReadFile(inputFile,countWorker);
        List<String> stringList = read.readFile();
        word = new ArrayBlockingQueue<>(stringList.size(),true,stringList);
//            commonWord = new ArrayBlockingQueue<>(stringList.size());
        Storage storage = new Storage(word, stringList);

        for (int i = 0; i < countWorker; i++) {
            listTread.add(new Thread(new Worker(storage)));
        }
        for (int i = 0; i < countWorker; i++) {
            listTread.get(i).start();
        }
        for (int i = 0; i < countWorker; i++) {
            try {
                listTread.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.print();
    }


}
