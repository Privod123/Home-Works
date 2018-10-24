package Lessons_3;
/*
Требуется удалить из неё повторяющиеся символы и все пробелы.
Например,
если было введено "abc cde def", то должно быть выведенно "abcdef".
 */

import java.util.Arrays;

public class Zadacha_6_String {
    public static void main(String[] args) {
        String checkString = "abc cde def 1#@ ? ,";
        checkString = checkString.replaceAll("[^a-z]+", " ").replaceAll("\\s","").trim();
        System.out.println(checkString);
        char[] charString = checkString.toCharArray();
        String newSreing = "";
        for (int i = 0; i < charString.length ; i++) {
            if (!newSreing.contains(String.valueOf(charString[i]))) {
                newSreing = newSreing.concat(String.valueOf(charString[i]));
            }

        }
        System.out.println(newSreing);

    }
}
