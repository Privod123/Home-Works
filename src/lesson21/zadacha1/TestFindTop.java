package lesson21.zadacha1;

import java.io.File;

/**
 * Created by Hello on 13.12.2018.
 */
public class TestFindTop {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FindTop100Word top100Word = new FindTop100Word();
        top100Word.start();
        long finish = System.currentTimeMillis();
        System.out.println("Время работы : " + (finish - start)/1000l + " сек.");

    }
}
