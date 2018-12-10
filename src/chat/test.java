package chat;

import java.util.Scanner;

/**
 * Created by Hello on 04.12.2018.
 */
public class test {
    public static void main(String[] args) {
        while (true){
            ConsoleHelper.writeString("введите строку");
            String text = ConsoleHelper.readString();
            ConsoleHelper.writeString("вы ввели " + text);
        }
//        Scanner in;
//        while (true){
//            in = new Scanner(System.in);
//            String text = in.nextLine();
//            System.out.println(text);
//        }
    }
}
