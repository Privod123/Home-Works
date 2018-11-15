package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 16
 Пользователь вводит с клавиатуры 20 слов.
 Нужно подсчитать количество одинаковых слов в списке.
 Результат нужно представить в виде Map<String, Integer>, где первый параметр – уникальная строка, а второй – число,
 сколько раз данная строка встречалась в списке.
 Вывести результат на экран.
 Регистр влияет на результат.

 */
public class Zadacha16 {
    public static void main(String[] args) {
        Map<String,Integer> countWord = new HashMap<>();
        List<String> listWord = new ArrayList<>(20);
        Scanner in;
        int i = 0;
        System.out.println("Введите 20 слов.");
        while (i < 20){
            in = new Scanner(System.in);
            String word = in.nextLine();
            listWord.add(word);
            countWord.put(word, 0);
            i++;
        }
        label: for (String l: listWord) {
                    for (Map.Entry<String,Integer> m : countWord.entrySet()) {
                         if (l.equals(m.getKey())) {
                            countWord.put(l,m.getValue() + 1);
                            continue label;
                         }
                    }
                }

        for (Map.Entry<String,Integer> m : countWord.entrySet()) {
            System.out.println("Слово " + m.getKey() + " встречается " + m.getValue() + " раз");
        }
//        in.close();
    }
}
