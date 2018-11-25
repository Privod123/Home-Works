package lesson15;

import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;

/**
 * Created by Hello on 24.11.2018.
 */
public class IOStreamTxtFile{

    private String nameFile;
    private String inputNameFile;
    private String outputNameFile;
    private  boolean nameFileIsNorma; // проверяем что указанный файл расширения TXT
    private  boolean inputFileIsNorma; // проверяем что указанный файл расширения TXT
    private  boolean outputFileIsNorma;  // проверяем что указанный файл расширения TXT

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

    public IOStreamTxtFile(String inputNameFile, String outputNameFile)  {
        if (inputNameFile.toLowerCase().endsWith(".txt") ){
            this.inputNameFile = inputNameFile;
            inputFileIsNorma = true;
        }else {
            System.out.println("Введенный файл из которого читаем не является текстовым(не имеет расширение TXT)");
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputNameFile.toLowerCase().endsWith(".txt")){
            this.outputNameFile = outputNameFile;
            outputFileIsNorma = true;
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
        if (inputFileIsNorma == true && outputFileIsNorma == true){
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
}
