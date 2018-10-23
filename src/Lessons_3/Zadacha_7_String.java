package Lessons_3;
/*
Вводиться строка,содержащая буквы,целые неотрицательные числа и иные символы.
Требуется все числа,которые встречаются в строке,поместить в отдельный целочисленный массив.
Например, если дана сторка "дом 48,корпус 9, парадная 7, этаж 4", то в массиве должны оказаться числа 48,9,7 и 4.
 */

import java.util.Arrays;

public class Zadacha_7_String {
    public static void main(String[] args) {
        String words = "дом 48,корпус 9, парадная 7, этаж 4";
        String newString = words.replaceAll("[^0-9]+"," ");
        newString = newString.trim();
        String[] munMassivString = newString.split(" ");
        int[] munMassiv = new int[munMassivString.length];
        for (int i = 0; i < munMassivString.length; i++) {
            munMassiv[i] = Integer.valueOf(munMassivString[i]);
        }
        System.out.println(Arrays.toString(munMassiv));

    }
}
