package lessons11.zadachiCollection;

import java.util.*;

/**
 * Created by Hello on 13.11.2018.
 * Задача 14
 Написать программу, которая считывает с клавиатуры имя месяца и выводит его номер на экран в виде: «Май 5 месяц».
 Использовать коллекции.

 */
public class Zadacha14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String,Integer> month = new HashMap<>();
        month.put("Январь", 1);
        month.put("Февраль", 2);
        month.put("Март", 3);
        month.put("Апрель", 4);
        month.put("Май", 5);
        month.put("Июнь", 6);
        month.put("Июль", 7);
        month.put("Август", 8);
        month.put("Сентябрь", 9);
        month.put("Октябрь", 10);
        month.put("Ноябрь", 11);
        month.put("Декабрь", 12);

        System.out.println("Введите месяц :");
        String writeMonth =  in.nextLine();
        int countMonth = 1;
        for (Map.Entry<String,Integer> m : month.entrySet()) {
            if (m.getKey().toLowerCase().equals(writeMonth.toLowerCase())){
                System.out.println(m.getKey() + " " + m.getValue() + " месяц");
                break;
            }
            if (countMonth == month.size()){
                System.out.println("Введнный месяц " + writeMonth + " отсутствует в русском календаре.");
            }
            countMonth++;
        }
        in.close();
    }
}
