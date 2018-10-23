package Lessons_3;
/*
Создайте массив из 15 случайных целых чисел из отрезка [0,9]. Выведите массив на экран.
Подсчитайте сколько в массиве четных элементов и выведите это количество на экран на отдельной строке.
 */

import java.util.Arrays;

public class Zadacha_3 {
    public static void main(String[] args) {
        int[] numMasiv = new int[15];
        for (int i = 0; i < numMasiv.length; i++) {
            numMasiv[i] =(int)(Math.random() * 10);
        }
        System.out.println("Выводим массив случайных чисел");
        System.out.println(Arrays.toString(numMasiv));
        int countEvenNumber = 0;
        for (int num: numMasiv) {
            if (num % 2 == 0) countEvenNumber++;
        }
        System.out.println("Количество четных элементов в массиве - " + countEvenNumber);
    }
}
