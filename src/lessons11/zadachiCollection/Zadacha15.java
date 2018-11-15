package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 15
 Коллекция хранит фамилии человека и город проживания.
 Считывая город с клавиатуры программа должна выводить фамилии  людей, живущих в данном городе.

 */
public class Zadacha15 {
    public static void main(String[] args) {
        HashMap<String,String> fsb = new HashMap<>();
        fsb.put("Иванов", "Волгорад");
        fsb.put("Петров", "Санкт-Петербург");
        fsb.put("Сидоров", "Сочи");
        fsb.put("Путин", "Москва");
        fsb.put("Медведев", "Сочи");

        System.out.println("Введите город :");
        Scanner in = new Scanner(System.in);
        String city = in.nextLine();
        int countSity = 1;
        for (Map.Entry<String,String> town: fsb.entrySet()) {
            if (town.getValue().toLowerCase().equals(city.toLowerCase())){
                System.out.println(town.getKey());
            }
            if (countSity == fsb.size()){
                System.out.println("В городе " + city + " никто не живет.");
            }
            countSity++;
        }
    }
}
