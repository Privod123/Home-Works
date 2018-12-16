package lesson22.zadacha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Hello on 16.12.2018.
 */
public class Storage {

    private BlockingQueue<String> word;
    private List<String> stringList;
    private Map<String,Integer> listWorker;
    private final String    DONE     = "DONE";

    public Storage( BlockingQueue<String> word,List<String> stringList) {
        this.word = word;
        this.stringList = stringList;
        listWorker = new HashMap<>();
        if (listWorker.isEmpty()) {
            for (String list : stringList) {
                if (!list.equals(DONE))
                    listWorker.put(list, 0);
            }
        }
    }


    public void find() {
        try {
            String msg;
            while (!(msg = word.take()).equals(DONE)) {
                for (Map.Entry<String, Integer> map : listWorker.entrySet()) {
                    if (map.getKey().equals(msg)) {
                        map.setValue(map.getValue() + 1);
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void print(){
        if (listWorker.isEmpty()){
            System.out.println("Общий список пуст");
        } else {
            listWorker.entrySet().stream().
                    sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).
                    limit(100).forEach(System.out::println);
        }
    }
}
