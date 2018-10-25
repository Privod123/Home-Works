package lesson4.zadacha2;

public class Note {
    private int var;
    private Note nextAdress;

    public Note(int var) {
        this.var = var;
    }

    public int getVar() {
        return var;
    }

    public void setNextAdress(Note nextAdress) {
        this.nextAdress = nextAdress;
    }

    public Note getNextAdres() {
        return nextAdress;
    }

    @Override
    public String toString() {
        return "Note{" +
                "var= " + var +
                ", nextAdress= " + nextAdress +
                '}';
    }
}
