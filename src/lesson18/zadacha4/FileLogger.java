package lesson18.zadacha4;

import java.io.*;

/**
 * Created by Hello on 11.12.2018.
 */
public class FileLogger implements ILogger {

    @Override
    public boolean write(String message) {
        byte[] bytesMessage = message.getBytes();
        File outputFile = new File("src\\lesson18\\zadacha4\\saveFile\\save.txt");
        try (OutputStream out = new FileOutputStream(outputFile);
            BufferedOutputStream bos = new BufferedOutputStream(out)){
                bos.write(bytesMessage,0,bytesMessage.length);
                return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
