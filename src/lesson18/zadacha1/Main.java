package lesson18.zadacha1;

import java.io.*;

/**
 * Created by Hello on 06.12.2018.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("src\\lesson18\\File\\z1.txt");
        File file1 = new File("src\\lesson18\\File\\z1_out.txt");
        byte[] password = "password".getBytes();
            try (OutputStream out = new CryptoOutputStream(new FileOutputStream(file1),password);
                    InputStream in = new CryptoInputStream(new FileInputStream(file), password)
                    ){
                byte[] byteArr = new byte[in.available()];
                while ((in.read(byteArr)) > 0){
                    out.write(byteArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        File file2 = new File("src\\lesson18\\File\\z2_out.txt");
        try ( OutputStream out = new CryptoOutputStream(new FileOutputStream(file2),password);
              InputStream in = new CryptoInputStream(new FileInputStream(file1), password)
        ){
            byte[] byteArr = new byte[1];
            while ((in.read(byteArr)) > 0){
                out.write(byteArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
