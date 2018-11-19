package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 7
 Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
 Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
 Результат вывести на экран

 */
public class Zadacha7 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Дмитрий");
        map.put("Сидоров", "Сергей");
        map.put("Штольц", "Юрий");
        map.put("Долгорукий", "Юрий");
        map.put("Иванов", "Сергей");
        map.put("Путин", "Владимир");
        map.put("Медведев", "Александр");

        checkName(map,"r");
    }

    static void checkName(Map<String,String> map,String name){
        int count = 0;
        for (Map.Entry<String,String> m : map.entrySet()) {
            if (m.getValue().equals(name))count++;
        }
        if (count == 0) {
            System.out.println("Нет совпадений в словаре по имени : " + name);
        }else {
            System.out.println("В словаре совпадение по имени " + name + " - " + count + " раз.");
        }
    }
}
