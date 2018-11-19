package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 8
 Создать словарь (Map<String, String>) и внести в него десять записей по принципу: «фамилия» - «дата рождения».
 Удалить из словаря всех людей, родившихся летом.

 */
public class Zadacha8 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Путин","07.10.1952");
        map.put("Пушкин","06.06.1799");
        map.put("Шайгу","15.05.1972");
        map.put("Зюганов","23.08.1942");

        System.out.println(map);
        deleteSummerMonth(map);
        System.out.println("-----------------------");
        System.out.println(map);


    }

    static void deleteSummerMonth(Map<String,String> map){
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> p = iterator.next();
            String[] data = p.getValue().trim().split("\\D");;
            if (Integer.parseInt(data[1]) > 5 && Integer.parseInt(data[1]) < 9){
               iterator.remove();
            }
        }

    }
}
