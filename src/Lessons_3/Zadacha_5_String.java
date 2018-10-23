package Lessons_3;
/*
Найти в строке указанную подстроку и заменить ее на новую.
Строку,ее подстроку для замены и новую подстроку вводит пользователь.
 */
public class Zadacha_5_String {
    public static void main(String[] args) {
        String oldString = "Independence";
        String underString = "depen";
        System.out.println(oldString.replaceAll(underString, "_TOM_"));
    }
}
