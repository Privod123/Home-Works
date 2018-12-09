package lesson18.command;

/**
 * Created by Hello on 05.12.2018.
 */
public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor){
        super(processor);
    }
    @Override
    String name() {
        return "ProcessCommand";
    }

        @Override
    boolean execute(StringBuilder sb, Storage storage) {
        sb.append("-------------------------");
        storage.add(sb.toString()); // запись данных в хранилище
        return true;
    }
}
