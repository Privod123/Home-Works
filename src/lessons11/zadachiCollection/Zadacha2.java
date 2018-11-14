package lessons11.zadachiCollection;

/**
 * Created by Hello on 13.11.2018.
 * Задача 2
 Написать программу со следующим функционалом:
 Считывание 20 чисел с клавиатуры,
 сохранение их в список,
 сортировка по трём другим спискам:
 число нацело делится на 3,
 нацело делится на 2 и
 все остальные.
 Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.

 Метод printList() должен выводить на экран все элементы всех списков с новой строки.
 Метод printList(String listName) должен выводить на экран все элементы указанного списка

 */
import java.util.*;

public class Zadacha2 {

    ArrayList<Integer>  generalList = new ArrayList<>(20);
    ArrayList<Integer>  listDeleniaNa2 = new ArrayList<>();
    ArrayList<Integer>  listDeleniaNa3 = new ArrayList<>();
    ArrayList<Integer>  otherList = new ArrayList<>();
//
    {
        Scanner in;
        int i = 0;
        while (i < 20){
            in = new Scanner(System.in);
            int number = in.nextInt();
            generalList.add(number);
            if (number % 2 == 0) listDeleniaNa2.add(number);
            if (number % 3 == 0) listDeleniaNa3.add(number);
            if (number % 2 != 0 && number % 3 != 0) otherList.add(number);
            i++;
        }
    }

    void printList(ArrayList<Integer> list1,ArrayList<Integer> list2,
                          ArrayList<Integer> list3,ArrayList<Integer> list4) {
        System.out.println("Выводим полный список");
        for (Integer i : list1) {
            System.out.println(i);
        }
        System.out.println("Выводим список чисел с деление на 3 без остатка");
        for (Integer i : list2) {
            System.out.println(i);
        }
        System.out.println("Выводим список чисел с деление на 2 без остатка");
        for (Integer i : list3) {
            System.out.println(i);
        }
        System.out.println("Выводим список чисел чего осталось");
        for (Integer i : list4) {
            System.out.println(i);
        }
    }
    void printList(ArrayList<Integer> listName){
        System.out.println("Выводим запрощенный список");
        for (Integer i : listName) {
            System.out.println(i);
        }
    }
    void printList(String listName){
        System.out.println("Выводим список с именем " + listName);
        if (listName.equals("%3")){
            printList(listDeleniaNa3);
        }else  if (listName.equals("%2")){
            printList(listDeleniaNa2);
        } else if (listName.equals("general")){
            printList(generalList);
        } else if (listName.equals("other")){
            printList(otherList);
        } else {
            System.out.println("Списка с именем " + listName + " нет");
        }
    }
    public static void main(String[] args) {
        Zadacha2 listZadacha = new Zadacha2();
        listZadacha.printList(listZadacha.generalList,listZadacha.listDeleniaNa3,listZadacha.listDeleniaNa2,listZadacha.otherList);
        listZadacha.printList(listZadacha.otherList);
        listZadacha.printList("%3");

    }
}
