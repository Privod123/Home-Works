package Lessons_3;

import java.util.Arrays;
import java.util.Scanner;

/*
Пользователь должен указать с клавиатуры чётное положительное число,а программа должна создать массив указанного
размера из случайных целых чисел из [-5,5] и вывести его на экран в строку. После этого программа должна определить
и сообщить пользователю о том, сумма модулей какой половины массива больше:левой или правой,лиюо сообщить,
что эти суммы модулей равны. Если пользователь введет неподходящее число,то программа должна требовать повторного
ввода до тех пор,пока не будет указаго корректное значение
 */
public class Zadacha_4 {
    public static void main(String[] args) {
        Scanner in;
        int[] masNumber;
        System.out.println("Введите чётное целое положительное число :");
        while (true){
            in = new Scanner(System.in);
            int lenghtMassiv = in.nextInt();
            if (lenghtMassiv < 0){
                System.out.println("Ошибка.Введено отрицательно число");
                System.out.println("Попробуйте ввести четное целое положительное число.");
                continue;
            }else if (lenghtMassiv == 0){
                System.out.println("Ошибка.Введено число - ноль");
                System.out.println("Попробуйте ввести четное целое положительное число.");
                continue;
            }else {
                masNumber = new int[lenghtMassiv];
                break;
            }
        }
        //---------------------------------------
        int min = -5;
        int max = 5;
        for (int i = 0; i < masNumber.length; i++) {
            masNumber[i] = min + (int) (Math.random() * (max - min) + 1);
        }
        System.out.println("Выводим массив случайных чисел :");
        System.out.println(Arrays.toString(masNumber));
        int sumLeftPartMassiv = 0;
        int sumRightPartMassiv = 0;
        for (int i = 0; i < masNumber.length/2 ; i++) {
            sumLeftPartMassiv +=masNumber[i];
            sumRightPartMassiv += masNumber[masNumber.length - 1 - i];
        }
        //---------------------------------------
        if (sumLeftPartMassiv < sumRightPartMassiv)
                            System.out.println("Сумма модулей правой половины больше чем левой");
        else if (sumLeftPartMassiv > sumRightPartMassiv)
                            System.out.println("Сумма модулей левой половины больше чем право");
        else System.out.println("Cуммы модулей равны");

    }
}
