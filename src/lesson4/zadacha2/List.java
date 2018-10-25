package lesson4.zadacha2;

public class List {
    private Note currentIndex;
    private Note headIndex;
    // метод добавляет элемент в список
    public  void add(int var){
        Note newNote = new Note(var);
        if (currentIndex == null){
            currentIndex = newNote;
            headIndex = currentIndex;
        }else {
            newNote.setNextAdress(currentIndex);
            currentIndex = newNote;
            headIndex = currentIndex;
        }
    }
    // метод удаляет элемент из списка
    public void remove (int var){
        Note index = headIndex;
        if (index.getVar() == var){
            currentIndex = currentIndex.getNextAdres();
        }
        while (index != null){
            if (index.getNextAdres() == null){
                System.out.println("значения - " + var + " нет в списке" );
                break;
            } else if (index.getNextAdres().getVar() == var){
                index.setNextAdress(index.getNextAdres().getNextAdres());
                break;
            } else {
                index = index.getNextAdres();
            }
        }
    }

    public Note getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Note currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Note getHeadIndex() {
        return headIndex;
    }
}
