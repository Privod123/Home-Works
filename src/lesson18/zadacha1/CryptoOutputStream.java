package lesson18.zadacha1;

import java.io.*;
/**
 * Created by Hello on 07.12.2018.
 */
public class CryptoOutputStream extends FilterOutputStream implements Closeable{

    private byte[] passord;
    private int number = 0;

    public CryptoOutputStream(OutputStream out,byte[] password) {
        super(out);
        this.passord = password;
    }

    @Override
    public void write(int b) throws IOException {
         int l = b ^ passord[number % passord.length];
         number++;
         super.write(l);
        //super.flush();
    }
}
