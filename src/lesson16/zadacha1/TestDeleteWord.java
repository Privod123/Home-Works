package lesson16.zadacha1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Hello on 01.12.2018.
 */
public class TestDeleteWord {
    public static void main(String[] args) {
        ReadConsole readConsole = new ReadConsole();
        readConsole.readConsol();
        DeleteWord deleteWord = new DeleteWord();
        deleteWord.deleteWordFromFile(readConsole.inputNameFile,
                                        readConsole.startLimit,
                                            readConsole.finishLimit,
                                                readConsole.outputNameDir,
                                                    readConsole.outputNameFile);

    }
}
