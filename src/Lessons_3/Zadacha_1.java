package Lessons_3;
/*
Создайте массив из всех четных чисел от 2 до 20 и выведите элементы массива на экран сначало в строку,
отделяя один элемент от другого  пробелом, а затем в столбик( отделяя один элеиент от другого началом новой строки).

 */

public class Zadacha_1 {
    public static void main(String[] args) {
       int[] masNumber = {2,4,6,8,10,12,14,16,18,20};
        System.out.println("Выводим в строчку :");
        for (int num: masNumber) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        System.out.println("Выводим в столбик :");
        for (int num: masNumber) {
            System.out.println(num);
        }
    }
}
