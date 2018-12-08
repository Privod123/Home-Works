package lesson18.command;

/**
 * Created by Hello on 05.12.2018.
 */
public class ExitCommand extends Command {

    public ExitCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ExitCommand";
    }

    @Override
    boolean execute(StringBuilder sb, Storage storage, int countMesage) {
        return true;
    }
}
