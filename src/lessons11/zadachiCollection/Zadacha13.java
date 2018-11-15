package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 13
 Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
 Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList<String>.
 Метод createList должен возвращать созданный массив.
 Метод createList должен добавлять в массив элементы (списки строк). Списки должны быть не пустые.

 */
public class Zadacha13 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A1");
        list1.add("B1");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("A2");
        list2.add("B2");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("A3");
        list3.add("B3");

        ArrayList<ArrayList<String>> generslList = new ArrayList<>();
        generslList.add(list1);
        generslList.add(list2);
        generslList.add(list3);

        System.out.println(Arrays.toString(createList(generslList)));
    }

    static ArrayList<String>[] createList(ArrayList<ArrayList<String>> list){
        ArrayList<String>[] res = new ArrayList[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).isEmpty()) {
                res[i] = null;
                continue;
            }
            else {
                res[i] = list.get(i);
            }
        }
        return res;
    }
}
