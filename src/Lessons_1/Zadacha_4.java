package Lessons_1;

/*
Вывести в консоль ближайщие к 10 из двух чисел,записанных в переменной m и n.
Метод Math.abs(n) возвращает абсолютное значение числа (модуль числа).
Например:
Среди чисел 8.5 и 11.45 ближайщее к десяти 11.45
 */

public class Zadacha_4 {
    public static void main(String[] args) {
        double n = 8.12;
        double m = 12.67;
        System.out.println((Math.abs(10 - n) > Math.abs(10 - m)) ? m : n);
    }
}
