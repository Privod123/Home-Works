package Lessons_2;
/*
Создайте программу,выводящую на экран первые 20 элементов последовательности
2 4 8 16 32 64 128 ...
 */

public class Zadacha_3 {
    public static void main(String[] args) {
        int a = 2;
        for (int i = 1; i <= 20; i++) {
            System.out.print ((int) Math.pow(a,i) + " ");
        }
    }
}
