package lesson15;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Hello on 24.11.2018.
 */
public class IOStreamTxtFile{
    //------------------------------------------------------------------------------------------------------------------
    public void copyFile(String inputNameFile, String outputNameFile,Charset charset) {
        if (checkFileTxt(inputNameFile) == true && checkFileTxt(outputNameFile) == true){
            System.out.println("Началась процедура копирования файла.");
            File inputFile = new File("TxTFile\\" + inputNameFile);
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
                File outputFile = new File("TxTFile\\" + outputNameFile);
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
    public byte[] read(String inputNameFile){
        byte[] readWithFile = null; // информацию что прочитали из файла
        if (checkFileTxt(inputNameFile) == true) {
            System.out.println("Началась процедура чтения файла.");
            File inputFile = new File("TxTFile\\" + inputNameFile);
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
    public void write(String outputNameFile, byte[] massivBytes){
        if (checkFileTxt(outputNameFile) == true){
            System.out.println("Началась процедура записи в файл.");
            File outputFile = new File("TxTFile\\" + outputNameFile);
            try {
                try (OutputStream out = new FileOutputStream(outputFile,false);
                     BufferedOutputStream bout = new BufferedOutputStream(out)){
                    System.out.println("Колличество скопированных байт в файл " + outputNameFile + " : " + massivBytes.length);
                    bout.write(massivBytes,0,massivBytes.length);
                }
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
            System.out.println("Окончена процедура записи в файл.");
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void mergeTwoFiles(String inputNameFile1,String inputNameFile2, Charset charset){
        if (checkFileTxt(inputNameFile1) == true && checkFileTxt(inputNameFile2) == true){
            System.out.println("Началась процедура склеивания двух файлов.");
            File inputFile1 = new File("TxTFile\\" + inputNameFile1);
            File inputFile2 = new File("TxTFile\\" + inputNameFile2);
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
                File outputFile = new File("TxTFile\\" + inputNameFile1);
                try {
                    try (OutputStream out = new FileOutputStream(outputFile,false);
                         BufferedOutputStream bout = new BufferedOutputStream(out)){
                        byte[] bytes = text.getBytes();
                        bout.write(bytes,0,bytes.length);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл");
                }
                System.out.println("Закончилась процедура склеивания двух файлов.");
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public void splitFile(String inputNameFile,String outputNameFile1,String outputNameFile2, int pos ){
        if (checkFileTxt(inputNameFile) == true &&
                checkFileTxt(outputNameFile1) == true &&
                checkFileTxt(outputNameFile2) == true){
            System.out.println("------------------------------------");
            byte[] bytesFile = read(inputNameFile);
            System.out.println("------------------------------------");
            if (pos > bytesFile.length || pos < 0){
                System.out.println("Введное чило, разбивающее массив не корректно");
                try {
                     throw new IOException();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                byte[] bytesOutFile1 = new byte[pos];
                byte[] bytesOutFile2 = new byte[bytesFile.length - pos];
                System.arraycopy(bytesFile,0,bytesOutFile1,0,pos);
                System.arraycopy(bytesFile,pos,bytesOutFile2,0,bytesFile.length - pos);
                write(outputNameFile1,bytesOutFile1);
                System.out.println("------------------------------------");
                write(outputNameFile2,bytesOutFile2);
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    private boolean checkFileTxt(String file){
        if (file.toLowerCase().endsWith(".txt") ){
            return  true;
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return false;
            }
        }
    }
}
