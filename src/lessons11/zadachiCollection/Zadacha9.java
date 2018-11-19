package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 9
 Создать Map<String, Integer> и внести в него десять записей по принципу: «фамилия» - «зарплата».
 Удалить из всех людей, у которых зарплата ниже введенного с клавиатуры числа

 */
public class Zadacha9 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A1",200);
        map.put("A2",800);
        map.put("A3",500);
        map.put("A4",600);
        map.put("A5",300);
        map.put("A6",400);

        System.out.println(map);
        System.out.println("Введите число :");
        Scanner in = new Scanner(System.in);
        int price = in.nextInt();
        in.close();

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> p = iterator.next();
            if (p.getValue() < price){
                iterator.remove();
            }
        }
        System.out.println(map);
    }
}
