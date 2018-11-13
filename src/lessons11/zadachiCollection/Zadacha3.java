package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 3
 Написать программу со следующим функционалом:
 Считывание  с клавиатуры 10 слов в список строк.
 Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
 Метод printList()  должен выводить результат на экран (каждое значение с новой строки).

 */
public class Zadacha3 {
    ArrayList<String> listString = new ArrayList<>(10);
    ArrayList<String> newListString = new ArrayList<>(20);
    Scanner in;
    {
        int i = 0;
        while (i < 10){
            in = new Scanner(System.in);
            listString.add(in.nextLine());
            i++;
        }
        in.close();
    }
    void doubleValues(){
        for (String s : listString) {
            newListString.add(s);
            newListString.add(s);
        }
    }
    void printList(){
        for (String s: newListString) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        Zadacha3 zadacha3 = new Zadacha3();
        zadacha3.doubleValues();
        zadacha3.printList();
    }
}
