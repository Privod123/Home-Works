package lesson18.command;

/**
 * Created by Hello on 05.12.2018.
 */
public class TestCommandPattern {

    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        textProcessor.start();

    }
}
