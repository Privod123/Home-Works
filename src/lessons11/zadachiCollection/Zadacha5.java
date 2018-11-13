package lessons11.zadachiCollection;

import java.util.*;
/**
 * Created by Hello on 13.11.2018.
 * Задача 5
 Написать программу, которая должна:
 Считывать с клавиатуры 10 слов в список строк.
 Определять, является ли список упорядоченным по возрастанию длины строки.
 В случае отрицательного ответа выводить на экран номер первого элемента, нарушающего такую упорядоченность.

 */
class CheckString{
    Scanner in;
    ArrayList<String> list = new ArrayList<>(10);
    {
        int i = 0;
        while (i < 10){
            in = new Scanner(System.in);
            list.add(in.nextLine());
            i++;
        }
        in.close();
    }

    public void chekGrownElementList(){
        int minLenghtBeforeElement = list.get(0).length();
        for (int i = 0; i < list.size(); i++) {
            if ( list.get(i).length() < minLenghtBeforeElement){
                System.out.println("Номер элемент короче предыдущего : " + (i + 1));
                break;
            }
            minLenghtBeforeElement = list.get(i).length();
        }
        System.out.println("В листе все элементы лежат по возрастанию длины строки");
    }
}
public class Zadacha5 {
    public static void main(String[] args) {
        CheckString checkString = new CheckString();
        checkString.chekGrownElementList();
    }
}
