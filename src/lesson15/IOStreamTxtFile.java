package lesson15;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Hello on 24.11.2018.
 */
public class IOStreamTxtFile{

    private String nameFile;
    private String nameFile1;
    private String nameFile2;
    private File[] files;
    private  boolean nameFileIsNorma; // проверяем что указанный файл расширения TXT
    private  boolean nameFile1IsNorma; // проверяем что указанный файл расширения TXT
    private  boolean nameFile2IsNorma;  // проверяем что указанный файл расширения TXT

    public IOStreamTxtFile(String nameFile) {
        if (nameFile.toLowerCase().endsWith(".txt") ){
            this.nameFile = nameFile;
            nameFileIsNorma = true;
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public IOStreamTxtFile(String nameFile1, String nameFile2)  {
        if (nameFile1.toLowerCase().endsWith(".txt") ){
            this.nameFile1 = nameFile1;
            nameFile1IsNorma = true;
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (nameFile2.toLowerCase().endsWith(".txt")){
            this.nameFile2 = nameFile2;
            nameFile2IsNorma = true;
        }else {
            System.out.println("Введенный файл в который читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void copyFile(Charset charset) {
        if (nameFile1IsNorma == true && nameFile2IsNorma == true){
            System.out.println("Началась процедура копирования файла.");
            File inputFile = new File("TxTFile\\" + nameFile1);
            String text = null; // информацию что прочитали из файла
            boolean readIsNorma = false; // проверяем что чтение файла прошло успешно
            //---------------------------------------------------
            try {
                try (InputStream in = new FileInputStream(inputFile);
                     BufferedInputStream bis = new BufferedInputStream(in);
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
                ){
                    int l;
                    while ((l = bis.read()) != -1){
                        byteArrayOutputStream.write(l);
                    }
                    text = new String(byteArrayOutputStream.toByteArray(),charset);
                    readIsNorma = true;
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            }
            //---------------------------------------------------
            if (readIsNorma == true){
                File outputFile = new File("TxTFile\\" + nameFile2);
                try {
                    try (OutputStream out = new FileOutputStream(outputFile,false);
                         BufferedOutputStream bout = new BufferedOutputStream(out)){
                        byte[] bytes = text.getBytes();
                        System.out.println("Колличество скопированных байт : " + bytes.length);
                        bout.write(bytes,0,bytes.length);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл");
                }
                System.out.println("Закончилась процедура копирования файла.");
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public byte[] read(){
        byte[] readWithFile = null; // информацию что прочитали из файла
        if (nameFileIsNorma == true) {
            System.out.println("Началась процедура чтения файла.");
            File inputFile = new File("TxTFile\\" + nameFile);
            try {
                try (InputStream in = new FileInputStream(inputFile);
                     BufferedInputStream bis = new BufferedInputStream(in);
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
                ) {
                    int l;
                    while ((l = bis.read()) != -1) {
                        byteArrayOutputStream.write(l);
                    }
                    readWithFile = byteArrayOutputStream.toByteArray();
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            }
        }
        System.out.println("Закончилась процедура чтения файла.");
        return readWithFile;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void write(byte[] massivBytes){
        System.out.println("Началась процедура записи в файл.");
        File outputFile = new File("TxTFile\\" + nameFile);
        try {
            try (OutputStream out = new FileOutputStream(outputFile,false);
                 BufferedOutputStream bout = new BufferedOutputStream(out)){
                System.out.println("Колличество скопированных байт в файл " + nameFile + " : " + massivBytes.length);
                bout.write(massivBytes,0,massivBytes.length);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        System.out.println("Окончена процедура записи в файл.");
    }
    //------------------------------------------------------------------------------------------------------------------
    public void mergeTwoFiles(Charset charset){
        if (nameFile1IsNorma == true && nameFile2IsNorma == true){
            System.out.println("Началась процедура склеивания двух файлов.");
            File inputFile1 = new File("TxTFile\\" + nameFile1);
            File inputFile2 = new File("TxTFile\\" + nameFile2);
            String text = null; // информацию что прочитали из файла
            boolean readIsNorma = false; // проверяем что чтение файла прошло успешно
            //---------------------------------------------------
            try {
                try (InputStream in1 = new FileInputStream(inputFile1);
                     InputStream in2 = new FileInputStream(inputFile2);
                     BufferedInputStream bis1 = new BufferedInputStream(in1);
                     BufferedInputStream bis2 = new BufferedInputStream(in2);
                     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
                ){
                    int l1;
                    while ((l1 = bis1.read()) != -1){
                        byteArrayOutputStream.write(l1);
                    }
                    int l2;
                    while ((l2 = bis2.read()) != -1){
                        byteArrayOutputStream.write(l2);
                    }
                    text = new String(byteArrayOutputStream.toByteArray(),charset);
                    readIsNorma = true;
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
            }
            //---------------------------------------------------
            if (readIsNorma == true){
                File outputFile = new File("TxTFile\\" + nameFile1);
                try {
                    try (OutputStream out = new FileOutputStream(outputFile,false);
                         BufferedOutputStream bout = new BufferedOutputStream(out)){
                        byte[] bytes = text.getBytes();
                        System.out.println("Колличество скопированных байт : " + bytes.length);
                        bout.write(bytes,0,bytes.length);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл");
                }
                System.out.println("Закончилась процедура склеивания двух файлов.");
            }
        }
    }
}
