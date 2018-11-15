package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 12
 Ввести с клавиатуры число N.
 Считать N целых чисел и заполнить ими список.
 Найти минимальное число среди элементов списка.

 */
public class Zadacha12 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in;
        int n = 0;
        int i = 0;
        while (true){
            in = new Scanner(System.in);
            if (n == 0){
                System.out.println("Введите колличество строчек, которое будет считать (N)");
                n = in.nextInt();
                continue;
            }
            if (n < 0){
                System.out.println("Число N не может быть отрицательным");
                n = 0;
                continue;
            }
            if (i == n){
                break;
            }
            if (i == 0) System.out.println("Введите цифры :");
            list.add(in.nextInt());
            i++;
        }
        in.close();
        int min = Integer.MAX_VALUE;
        for (Integer k: list ) {
            if (k < min) min = k;
        }
        System.out.println("Минимальное число в списке : " + min);
    }
}
