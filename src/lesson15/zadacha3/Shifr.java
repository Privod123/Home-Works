package lesson15.zadacha3;

import lesson15.IOStreamTxtFile;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by Hello on 25.11.2018.
 */
public class Shifr {
    public static void main(String[] args) {
        String inputFile = null;
        String inputKey = null;
        String resSifraFile = null;
        Scanner in;
        while (true){
            in = new Scanner(System.in);
            if (inputFile == null){
                System.out.println("Введите имя файла с расширением который надо читать данные (Например - file.txt) :");
                inputFile = in.nextLine();
                continue;
            }else  if ( inputKey == null){
                System.out.println("Введите ключ шифрования :");
                inputKey = in.nextLine();
                continue;
            } else  if ( resSifraFile == null){
                System.out.println("Введите имя файла с расширением, в который надо записать защифрованный файл (Например - file.txt) :");
                resSifraFile = in.nextLine();
                continue;
            }else {
                break;
            }
        }
        in.close();

        IOStreamTxtFile iosTXT = new IOStreamTxtFile(inputFile);
        byte[] readFile = iosTXT.read();
        System.out.println("--------------------------");
        System.out.println("Строка до шифрования : ");
        System.out.println(new String(readFile,Charset.forName("UTF-8")));
        //----------------------------------------------
        System.out.println("--------------------------");
        System.out.println("Строка после шифрования : ");
        byte[] shifrFile = encodeAndDecode(readFile,inputKey);
        System.out.println(new String(shifrFile,Charset.forName("UTF-8")));
        IOStreamTxtFile iosTXT1 = new IOStreamTxtFile(resSifraFile);
        iosTXT1.write(shifrFile);
        //----------------------------------------------
        System.out.println("--------------------------");
        System.out.println("Строка после дешифрования");
        byte[] deshifrFile = encodeAndDecode(iosTXT1.read(),inputKey);
        System.out.println(new String(deshifrFile,Charset.forName("UTF-8")));

    }

    public static byte[] encodeAndDecode(byte[] text, String key){
        byte[] byteKey = key.getBytes();
        byte[] res = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            res[i] = (byte) (text[i] ^ byteKey[i % byteKey.length]);
        }
        return res;
    }
}
