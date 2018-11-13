package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 6
 Написать программу, которая должна:
 Считывать с клавиатуры 2 числа N и M.
 Ввести N строк и заполнить ими список.
 Переставить M первых строк в конец списка.
 Вывести список на экран, каждое значение с новой строки.

 */
public class Zadacha6 {
    public static void main(String[] args) {
        SmenaMest sm = new SmenaMest();
        System.out.println(sm.list);
//        sm.smena();
//        System.out.println(sm.list);
        sm.smena2();
        System.out.println(sm.list);
    }
}

class SmenaMest{
    Scanner in;
    ArrayList<String> list = new ArrayList<>();
    int n;
    int m;
    {
        int i = 0;
        while (i <= n){
            in = new Scanner(System.in);
            if (n == 0){
                System.out.println("Введите число N - это колличество строк в списке");
                n = in.nextInt();
                i++;
                continue;
            }
            if (m == 0){
                System.out.println("Введите число М - это колличество первых строк которые будут переставлены в конец списка");
                m = in.nextInt();
                continue;
            }
            if (m > n) {
                System.out.println("Число M не может быть меньше N");
                n = 0;
                m = 0;
                i = 0;
                continue;
            }
            list.add(in.nextLine());
            i++;

        }
    }
    public void smena(){
        for (int i = 0; i < m ; i++) {
            list.add(list.get(i));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
    public void smena2(){
        for (int i = 0; i < m ; i++) {
            list.add(list.get(0));
            list.remove(0);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
