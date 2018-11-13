package lessons11.zadachiCollection;

import java.util.*;

/**
 * Created by Hello on 13.11.2018.
 * Задача 1
 Написать программу со следующим функционалом:
 Считывание максимум 5 строк с клавиатуры,
 занесение строк в список,
 поиск самой короткой строки,
 вывод самой короткой строки на экран по запросу пользователя (команда в консоле /short string)
 Если одинаково коротких строк несколько, выводить каждую с новой строки.

 */
public class Zadacha1 {
    public static void main(String[] args) {
        Scanner in;
        ArrayList<String> list = new ArrayList<>(5);
        int minString = Integer.MAX_VALUE;
        int i = 0;
        while (true){
            in = new Scanner(System.in);
            String string = in.nextLine();
            if (string.equals("short string")) {
                for (String s : list) {
                    if (minString == s.length())
                        System.out.println(s);
                }
                System.out.println(list);
                break;
            }
            if ( i >= 5) {
                System.out.println("Список полон,внести новое значение " + string + " нельзя");
                continue;
            }
            list.add(string);
            if ( string.length() < minString) minString = string.length();
            i++;

        }

    }
}
