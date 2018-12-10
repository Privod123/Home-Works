package chat;

import java.util.Scanner;

/**
 * Created by Hello on 02.12.2018.
 */
public class ConsoleHelper {

     private static  Scanner read = new Scanner(System.in);

    //writeString - должен выводить строку в консоль
    public static void writeString(String string){
        System.out.println(string);
    }

    // readString - должен считывать строку с консоли
    public static String readString(){
        return read.nextLine();
    }
}
