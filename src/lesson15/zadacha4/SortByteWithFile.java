package lesson15.zadacha4;

import lesson15.IOStreamTxtFile;

import java.util.*;
/**
 * Created by Hello on 24.11.2018.
 */
public class SortByteWithFile {
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
        System.out.println("--------------------------");
        System.out.println("До сортировки байтов из файла");
        for (byte b : readBytes) {
            System.out.print(b + " ");
        }
        System.out.println(" ");
        Arrays.sort(readBytes);
        System.out.println("--------------------------");
        System.out.println("После сортировки байтов из файла в порядке возрастания");
        for (byte b : readBytes) {
            System.out.print(b + " ");
        }
        System.out.println(" ");
        System.out.println("--------------------------");
        System.out.println("После сортировки байтов из файла в порядке возрастания без учета повторяющихся");
        Set<Byte> sortBytes = new TreeSet<>();
        for (byte b : readBytes) {
            sortBytes.add(b);
        }
        for (Byte sortB: sortBytes) {
            System.out.print( sortB + " ");
        }
    }
}
