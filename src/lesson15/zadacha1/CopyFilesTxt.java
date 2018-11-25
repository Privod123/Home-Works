package lesson15.zadacha1;

import lesson15.IOStreamTxtFile;

import java.nio.charset.Charset;
import java.util.*;
/**
 * Created by Hello on 24.11.2018.
 */
public class CopyFilesTxt {
    public static void main(String[] args) {
        String inputFile = null;
        String outpupFile = null;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (inputFile == null){
                System.out.println("Введите имя файла с расширением который надо скопировать (Например - file.txt) :");
                inputFile = in.nextLine();
                continue;
            } else  if ( outpupFile == null){
                System.out.println("Введите имя файла с расширением в который надо записать (Например - file.txt) :");
                outpupFile = in.nextLine();
                continue;
            } else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile isoTXT = new IOStreamTxtFile();
        isoTXT.copyFile(inputFile,outpupFile,Charset.forName("UTF-8"));
    }
}
