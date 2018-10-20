package Lessons_2;
/*
Создайте программу,выводящую на экран все не отрицательные элементы последовательности
90 85 80 75 70 65 60 ...
 */

public class Zadacha_2 {
    public static void main(String[] args) {
        for (int i = 90; i > 0; i = i - 5) {
            System.out.print(i + " ");
        }
    }
}
