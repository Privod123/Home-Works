package lesson18.command;

/**
 * Created by Hello on 09.12.2018.
 */
public class RepeatCommand extends Command {


    public RepeatCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "RepeatCommand";
    }

    @Override
    boolean execute(StringBuilder sb, Storage storage) {
        storage.add(sb.toString()); // запись данных в хранилище
        return true;
    }
}
