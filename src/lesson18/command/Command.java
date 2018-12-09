package lesson18.command;

/**
 * Created by Hello on 05.12.2018.
 */
abstract public class Command {
    abstract String name();// имя команды
    abstract boolean execute(StringBuilder sb, Storage storage);


    protected TextProcessor processor;

    public Command(TextProcessor processor){
        this.processor = processor;
    }
}
