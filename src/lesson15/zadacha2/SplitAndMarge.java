package lesson15.zadacha2;

import lesson15.IOStreamTxtFile;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Hello on 25.11.2018.
 */
public class SplitAndMarge {
    public static void main(String[] args) {
        String inputFile1 = null;
        String inputFile2 = null;
        String inputFile3 = null;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (inputFile1 == null){
                System.out.println("Введите имя файла № 1 с расширением, который надо склеить (Например - file.txt) :");
                inputFile1 = in.nextLine();
                continue;
            } else  if ( inputFile2 == null){
                System.out.println("Введите имя файла № 2 с расширением, в который надо склеить (Например - file.txt) :");
                inputFile2 = in.nextLine();
                continue;
            } else  if ( inputFile2 == null){
                System.out.println("Введите имя файла № 2 с расширением, в который надо склеить (Например - file.txt) :");
                inputFile2 = in.nextLine();
                continue;
            } else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile iosTxT = new IOStreamTxtFile(inputFile1,inputFile2);
        iosTxT.mergeTwoFiles(Charset.forName("UTF-8"));
    }
}
