package Lessons_2;

/*
Проверить, является ли натуральное число - простым
 */

import java.util.Scanner;

public class Zadacha_4 {
    public static void main(String[] args) {
        Scanner in;
        while (true){
            System.out.println("Введите натуральное число");
            in = new Scanner(System.in);
            int number = in.nextInt();
            if (number <= 0){
                System.out.println("Вы ввели неправильное число");
                continue;
            }else if (number == 1 || number == 2 || number == 3 || number == 5 || number == 7){
                System.out.println( number + " - это простое число");
                break;
            }else if (number%2 == 0){
                System.out.println( number + " - это НЕ простое число");
                break;
            }else {
                int countDivider = 2;
                for (int i = 2; i <= (int) Math.sqrt(number) + 1; i++) {
                    if (number%i == 0) countDivider++;
                }
                if (countDivider == 2){
                    System.out.println( number + " - это простое число");
                    break;
                }else {
                    System.out.println( number + " - это НЕ простое число");
                    break;
                }
            }
        }
    }
}
