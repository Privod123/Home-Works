package Lessons_2;
/*
Вывести на экран первые 11 членов последовательности Фибоначи. Первый и второй члены последовательности равны единицам
,а каждый следующий - сумме двух предыдущих.
 */

public class Zadacha_5 {
    public static void main(String[] args) {
        System.out.println("11-тый член последовательности Фибоначи - " + poiskFibanachiIter(11));// итеративный способ
        System.out.println("11-тый член последовательности Фибоначи - " + poiskFibanachiRec(11)); // рекурсивный способ
    }

    public static int poiskFibanachiIter(int var) {
        int number1 = 1;
        int number2 = 1;
        for (int i = 3; i <= var; i++) {
            int temp = number1;
            number1 = number1 + number2;
            number2 = temp;
        }
        return number1;
    }
    private static int poiskFibanachiRec(int var) {
        int res = (var == 2 || var == 1)? 1 : (poiskFibanachiRec(var -2) + poiskFibanachiRec(var - 1));
        return res;
    }
}
