package lesson6.zadacha1;

public class Note {
    private Object var;
    private Note nextAdress;
    private int index;

    public Note(Object var) {
        this.var = var;
    }

    public Object getVar() {
        return var;
    }

    public void setNextAdress(Note nextAdress) {
        this.nextAdress = nextAdress;
    }

    public Note getNextAdress() {
        return nextAdress;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Note{" +
                "var=" + var +
                ", nextAdress=" + nextAdress +
                ", index=" + index +
                '}';
    }
}
