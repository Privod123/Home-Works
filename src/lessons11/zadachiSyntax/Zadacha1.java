package lessons11.zadachiSyntax;

import java.util.Scanner;

/**
 * Created by Hello on 13.11.2018.
 * Задача 1 (типы данных)
 Написать следующую программу:
 1. Программа должна считывать строки с клавиатуры.
 и прекращать считывать данные после того как была введена строка "exit".
 2. Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double -
 должен быть вызван метод print(Double value).
 3. Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0,
 но меньше 128 - должен быть вызван метод print(short value).
 4. Если введенная строка может быть корректно преобразована в число типа Integer
 и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
 5. Во всех остальных случаях должен быть вызван метод print(String value).

 */
public class Zadacha1 {
    public static void main(String[] args) {
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            String line = in.nextLine();
            if (line.equals("exit")) {
                break;
            } else if (line.contains(".") && checkStringDouble(line)){
                print(Double.parseDouble(line));
            } else if (checkStringShort(line)){
                print(Short.parseShort(line));
            } else if (checkStringInteger(line)){
                print(Integer.parseInt(line));
            } else {
                System.out.println("String : " + line);
            }
        }
        in.close();
    }
    static void print(Double value){
        System.out.println("Double : " + value);
    }
    static void print(short value){
        System.out.println("Short : " + value);
    }
    static void print(Integer value){
        System.out.println("Integer : " + value);
    }
    // Проверяем является ли строка числом.
    static boolean checkString(String line){
        char [] chars = line.trim().toCharArray();
        int count = 0; // считаем количество чисел в строке
        int countPoint = 0; // считаем количество точек в строке
        int i = 0;
        if (chars[0] == '+' || chars[0] == '-') {
            i = 1;
            count++;
        }
        for ( ; i < chars.length; i++) {
            if (Character.isDigit(chars[i]) || chars[i] == '.') {
                if (chars[i] == '.'){
                    countPoint++;
                }
                count++;
            }
        }
        return (count == chars.length) && (countPoint <= 1) ? true : false;
    }

    // Проверяем является ли строка числом типа Double.
    static boolean checkStringDouble(String line){

        return checkString(line) ? true : false;
    }
    // Проверяем является ли строка числом типа Short.
    static boolean checkStringShort(String line){
        return (checkString(line)&&
                (Short.parseShort(line)> 0 ) &&
                (Short.parseShort(line) < 128)) ? true : false ;
    }
    // Проверяем является ли строка числом типа Integer.
    static boolean checkStringInteger(String line){

        return  (checkString(line) && Integer.parseInt(line) <= 0) ||
                (checkString(line) && Integer.parseInt(line) >= 128) ? true : false;
    }
}
