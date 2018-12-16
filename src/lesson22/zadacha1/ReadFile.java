package lesson22.zadacha1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hello on 16.12.2018.
 */
public class ReadFile {

    private File file;
    private int pointStop;

    public ReadFile(File file, int pointStop) {
        this.file = file;
        this.pointStop = pointStop;
    }

    public List<String> readFile(){
        List<String> list = null;
        List<String> words = new ArrayList<>();
        try {
            list = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0; //считает сколько строк текущих записано в лист
        int point = 1; //считает сколько точек СТОПов поставлено
        for (String line: list) {
            String[] wordSplit = line.toLowerCase().replaceAll("[^а-яё]"," ").trim().split("\\s+");
            for (String word: wordSplit) {
                if (word.length() > 0 ){
                    words.add(word.trim());
                }
            }
            if (list.size() * point/pointStop == count){
                words.add("DONE");
                point++;
            }
            count++;
        }
        words.add("DONE");
        return words;
    }
}
