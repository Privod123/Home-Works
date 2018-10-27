package lesson4.zadacha2;

public class List {
    private Note headIndex;
    // -------------------------------------
    // метод добавляет элемент в список
    public  void add(int var){
        Note newNote = new Note(var);
        if (headIndex == null){
            headIndex = newNote;
        }else {
            newNote.setNextAdress(headIndex);
            headIndex = newNote;
        }
    }
    // -------------------------------------
    // метод удаляет элемент из списка
    public void remove (int var){
        Note index = headIndex;
        if (index == null){
            System.out.println("Список пуст");
        }
        while (index != null){
            if (index == headIndex && headIndex.getVar() == var){
                headIndex = headIndex.getNextAdres();
                break;
            } else if (index.getNextAdres().getVar() == var) {
                index.setNextAdress(index.getNextAdres().getNextAdres());
                break;
            }
            else {
                index = index.getNextAdres();
            }
        }
    }

    // -------------------------------------
    // метод печатает элементы из списка
    public void print(){
        System.out.println("--------------------");
        Note index = headIndex;
        while ( index != null){
            System.out.println("Ячейка [" + index + "] содержит значение - " + index.getVar());
            index = index.getNextAdres();
        }
        System.out.println("--------------------");
    }

    public Note getHeadIndex() {
        return headIndex;
    }
}
