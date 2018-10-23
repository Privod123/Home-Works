package Lessons_3;
/*
Создайте массив из всех нечетных чисел от 1 до 99, выведите его на экран в строчку,а затем этот иассив
выведите на экран тоже в строчку,но в обратном порядке (99 97 95 93 ... 7 5 3 1)
 */

public class Zadacha_2 {
    public static void main(String[] args) {
        int[] masNumber = new int[50];
        int number = 1;
        for (int i = 0; i < masNumber.length; i++) {
            masNumber[i] = number;
            number +=2;
        }
        System.out.println("Выводим строчку по возрастания :");
        for (int num: masNumber) {
            System.out.print (num + " ");
        }
        System.out.println("");
        System.out.println("Выводим строчку по убыванию :");
        for (int i = masNumber.length - 1; i >= 0 ; i--) {
            System.out.print (masNumber[i] + " ");

        }
    }
}
