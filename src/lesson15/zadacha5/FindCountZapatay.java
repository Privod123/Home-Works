package lesson15.zadacha5;

import lesson15.IOStreamTxtFile;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Hello on 25.11.2018.
 */
public class FindCountZapatay {
    public static void main(String[] args) {
        String inputFile = null;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (inputFile == null){
                System.out.println("Введите имя файла с расширением который надо читать данные (Например - file.txt) :");
                inputFile = in.nextLine();
                continue;
            } else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile iosTXT = new IOStreamTxtFile(inputFile);
        byte[] readBytes = iosTXT.read();
        int countZapatay = 0;
        for (byte b: readBytes) {
            if (new String(new byte[]{b}, Charset.forName("UTF-8")).equals(",")){
                countZapatay++ ;
            }
        }
        System.out.println(" ");
        System.out.println("Kоличество запятых в файле : " + countZapatay);
    }
}
