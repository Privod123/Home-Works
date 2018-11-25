package lesson15.zadacha2;

import lesson15.IOStreamTxtFile;

import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Hello on 25.11.2018.
 */
public class SplitFile {
    public static void main(String[] args) {
        String inputFile1 = null;
        String outputFile1 = null;
        String outputFile2 = null;
        int pos = Integer.MIN_VALUE;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (inputFile1 == null){
                System.out.println("Введите имя файла с расширением, который надо считать (Например - file.txt) :");
                inputFile1 = in.nextLine();
                continue;
            } else  if ( outputFile1 == null){
                System.out.println("Введите имя файла № 1 с расширением, в который надо записать данные (Например - file.txt) :");
                outputFile1 = in.nextLine();
                continue;
            } else  if ( outputFile2 == null){
                System.out.println("Введите имя файла № 2 с расширением, в который надо записать оставшиеся данные (Например - file.txt) :");
                outputFile2 = in.nextLine();
                continue;
            } else  if ( pos == Integer.MIN_VALUE){
                System.out.println("Введите число которое разобьет массив прочитанных байтов файла :");
                pos = in.nextInt();
                continue;
            }else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile iosTxT = new IOStreamTxtFile();
        iosTxT.splitFile(inputFile1,outputFile1,outputFile2,pos);
    }
}
