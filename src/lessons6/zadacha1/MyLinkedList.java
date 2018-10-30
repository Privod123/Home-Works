package lessons6.zadacha1;
/*
Реализовать односвязный (или двусвязный) список.
Класс Связного списка должен реализовать следующие интерфейсы:

List и его методы:
add(Object obj, int index); - добавляет объект на указанную позицию (index)
remove(int index); - удаляет элемент с указанной позиции (index)
get(int index); - находит и возвращает элемент по индексу (index)
int size(); - возвращает размер списка

Stack и его методы:
push(Object obj); - добавляет объект в конец списка
pop(); - удаляет элемент из конца списка

Queue и его методы:
shift(Object obj); - добавляет объект в начало списка
unshift(); - удаляет элемент из начала списка
 */

public class MyLinkedList implements Stack,Queue{
    private Note currentElement;

    @Override
    public void push(int obj) {
        Note newNote = new Note(obj);

        if (currentElement == null){
            newNote.setNextAdress(null);
            newNote.setIndex(0);
            currentElement = newNote;
        }else {
            newNote.setNextAdress(currentElement);
            newNote.setIndex(currentElement.getIndex()+1);
            currentElement = newNote;
        }
            }

    @Override
    public void pop() {
        currentElement = currentElement.getNextAdress();
    }

    public void print(){
        System.out.println("--------------------");
        Note index = currentElement;
        while ( index != null){
            System.out.println("Ячейка [" + index + "] содержит значение - " + index.getVar());
            index = index.getNextAdress();
        }
        System.out.println("--------------------");
    }

    @Override
    public void shift(int var) {
        Note newNote = new Note(var);
        if (currentElement == null){
            newNote.setNextAdress(null);
            newNote.setIndex(0);
            currentElement = newNote;
        }else {
            newNote.setNextAdress(null);
            Note index = currentElement;
            while (index != null){
                index.setIndex(index.getIndex() + 1);
                if (index.getNextAdress() == null){
                    index.setNextAdress(newNote);
                    break;
                }
                index = index.getNextAdress();
            }
        }

    }

    @Override
    public void unshift() {
        Note index = currentElement;
        while (index != null){
            index.setIndex(index.getIndex() - 1);
            if (index.getNextAdress().getNextAdress() == null){
                index.setNextAdress(null);
                break;
            }
            index = index.getNextAdress();
        }
    }
}
