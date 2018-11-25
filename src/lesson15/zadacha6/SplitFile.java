package lesson15.zadacha6;

import lesson15.IOStreamTxtFile;

import java.util.Scanner;

/**
 * Created by Hello on 25.11.2018.
 */
public class SplitFile {
    public static void main(String[] args) {
        String file1 = null;
        String file2 = null;
        String file3 = null;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (file1 == null){
                System.out.println("Введите имя файла с расширением, который надо чтитать (Например - file.txt) :");
                file1 = in.nextLine();
                continue;
            }
            else  if ( file2 == null){
                System.out.println("Введите имя файла с расширением, в который надо записать (Например - file.txt) :");
                file2 = in.nextLine();
                continue;
            } else  if ( file3 == null){
                System.out.println("Введите имя файла с расширением, в который надо записать (Например - file.txt) :");
                file3 = in.nextLine();
                continue;
            }
            else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile iosTXT = new IOStreamTxtFile();
        byte[] readBytes = iosTXT.read(file1);
        System.out.println("--------------------------");
        System.out.println("Количество байт в файле " + file1 + " : " + readBytes.length);
        System.out.println("--------------------------");
        if (readBytes.length%2 == 0){
            byte[] bytesFile2 = new byte[readBytes.length/2];
            byte[] bytesFile3 = new byte[readBytes.length/2];
            System.arraycopy(readBytes,0, bytesFile2,0,readBytes.length/2);
            System.arraycopy(readBytes,readBytes.length/2, bytesFile3,0,readBytes.length/2);
            iosTXT.write(file2,bytesFile2);
            System.out.println("--------------------------");
            iosTXT.write(file3,bytesFile3);
        }else {
            byte[] bytesFile2 = new byte[readBytes.length/2 + 1];
            byte[] bytesFile3 = new byte[readBytes.length/2];
            System.arraycopy(readBytes,0,bytesFile2,0,readBytes.length/2 + 1);
            System.arraycopy(readBytes,readBytes.length/2 + 1,bytesFile3,0,readBytes.length/2);
            iosTXT.write(file2,bytesFile2);
            System.out.println("--------------------------");
            iosTXT.write(file3,bytesFile3);
        }

    }
}
