package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 11
 Создать два списка – LinkedList и ArrayList.
 Для этих списков  провести 10 тысяч вставок, удалений, а также вызовов get и set.
 То есть класс должен содержать перечисленные методы:
 insert10000(List list) должен вставлять 10 тысяч элементов в список.
 get10000(List list) должен вызывать 10 тысяч раз get у списка.
 set10000(List list) должен вызывать 10 тысяч раз set у списка.
 remove10000(List list) должен удалять 10 тысяч элементов из списка.

 Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
 Метод getTimeOfInsert() должен вернуть время выполнения в миллисекундах для каждого списка.

 */

class CheckWorkTime{

    void insert10000(List list){
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }

    void get10000(List list){
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
    }

    void set10000First(List list){
        for (int i = 0; i < 10000; i++) {
            list.set(0,i);
        }
    }
    void set10000HalfSize(List list){
        for (int i = 0; i < 10000; i++) {
            list.set(10000/2,i);
        }
    }
    void set10000Last(List list){
        for (int i = 0; i < 10000; i++) {
            list.set(9999,i);
        }
    }
    void remove10000(List list){
        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }
    }

    void getTimeOfInsert(List list){
        long startTime = System.currentTimeMillis();
        insert10000(list);
        long finishTime = System.currentTimeMillis();
        long res = finishTime - startTime;
        System.out.println("Время вставки 10000 элементов : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
        //-------------------------------------
        startTime = System.currentTimeMillis();
        get10000(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Время вызова 10000 элементов : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
        //-------------------------------------
        startTime = System.currentTimeMillis();
        set10000First(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Время вызова вставки 10000 элементов в начало списка : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
        //-------------------------------------
        startTime = System.currentTimeMillis();
        set10000First(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Время вызова вставки 10000 элементов в середину списка : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
        //-------------------------------------
        startTime = System.currentTimeMillis();
        set10000Last(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Время вызова вставки 10000 элементов в конец списка : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
        //-------------------------------------
        startTime = System.currentTimeMillis();
        remove10000(list);
        finishTime = System.currentTimeMillis();
        System.out.println("Время удаления 10000 элементов из списка : " + (finishTime - startTime) + " ms");
        System.out.println("Размер списка : " + list.size());
    }
}
public class Zadacha11 {
    public static void main(String[] args) {
        CheckWorkTime cwt = new CheckWorkTime();
        List<Integer> listArray = new ArrayList<>();
        List<Integer> listLinked = new ArrayList<>();

        System.out.println("Проверяем ArrayList");
        cwt.getTimeOfInsert(listArray);
        System.out.println("-------------------------------------");
        System.out.println("Проверяем LinkedList");
        cwt.getTimeOfInsert(listLinked);
    }
}
