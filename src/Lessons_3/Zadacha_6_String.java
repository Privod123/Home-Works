package Lessons_3;
/*
Требуется удалить из неё повторяющиеся символы и все пробелы.
Например,
если было введено "abc cde def", то должно быть выведенно "abcdef".
 */

import java.util.Arrays;

public class Zadacha_6_String {
    public static void main(String[] args) {
        String s = "abc cde def";
        char[] charString = s.toCharArray();
        Arrays.sort(charString);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charString.length - 1; i++) {
            if (charString[i + 1] != charString[i])
                stringBuilder.append(charString[i]);
            if (i == charString.length - 2)
                stringBuilder.append(charString[i + 1]);
        }
        System.out.println(stringBuilder.toString().trim());

    }
}
