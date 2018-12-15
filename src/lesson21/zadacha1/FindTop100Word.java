package lesson21.zadacha1;

import java.io.File;
import java.util.*;

/**
 * Created by Hello on 13.12.2018.
 */
public class FindTop100Word {

    private  List<Thread> listTread = new ArrayList<>();

    public void start(){
        // Создаем файл,окуда читаем текст
        File inputFile = new File("src\\lesson21\\zadacha1\\zad2.txt");

        ReadFile read = new ReadFile(inputFile); // Создаем обьект с помощью которого читаем

        int countThread = Runtime.getRuntime().availableProcessors(); // определяем сколько потоков запуститься на данной машине

        Storage storage = new Storage(); // Создаем обьект куда запишем результат чтения

        storage.setListWord(getListWordFromFile(read.readFile())); // читаем файл,затем записываем его в хранилище

        for (int i = 0; i < countThread; i++) {
            Thread thread = new ThreadFindWord(storage,
                                                storage.getListWord().size() * i/countThread,
                                                    storage.getListWord().size() * (i + 1)/countThread);
            listTread.add(thread);
        }
        for (int i = 0; i < countThread; i++) {
            listTread.get(i).start();
        }
        for (int i = 0; i < countThread; i++) {
            try {
                listTread.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("/-----------------------/");
        storage.printTop100();
        System.out.println("/-----------------------/");
    }

    public List<String> getListWordFromFile(String readString){
        List<String> listRes;
        String[] newReadString = readString.toLowerCase().replaceAll("[^а-яёА-ЯЁ]", " ").split("\\s+");
        listRes = Arrays.asList(newReadString);
        return listRes;
    }
}

class ThreadFindWord extends Thread{

    private Storage miniStorage;
    private int startElement;
    private int finishElement;

    public ThreadFindWord(Storage storage,int begin, int finish) {
        this.miniStorage = storage;
        this.startElement = begin;
        this.finishElement = finish;
    }

    @Override
    public void run() {
        miniStorage.findTopWord(startElement,finishElement);
    }
}
