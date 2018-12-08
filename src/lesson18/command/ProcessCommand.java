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
    boolean execute(StringBuilder sb, Storage storage, int countMesage) {
        sb.append("-------------------------");
        storage.add(sb.toString());
        sb.delete(0,sb.length());
        sb.append("-------------------------").append("\n").append(countMesage++).append("\n");
        return true;
    }
}
