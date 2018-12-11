package lesson18.command;

/**
 * Created by Hello on 10.12.2018.
 */
public class CancelCommand extends Command{

    public CancelCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "CancelCommand";
    }

    @Override
    boolean execute(StringBuilder sb, Storage storage) {
        return storage.remove() ? true : false ;
    }
}
