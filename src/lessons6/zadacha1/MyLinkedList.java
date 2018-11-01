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

import java.util.Iterator;

public class MyLinkedList implements Stack,Queue,List{

    private Note currentElement;
    //--------------------------------------------
    // Добавляем в конец листа новый элемент
    @Override
    public void push(Object obj) {
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
    //--------------------------------------------
    // Удаляем последний элемент из листа
    @Override
    public void pop() {
        currentElement = currentElement.getNextAdress();
    }
    //--------------------------------------------
    // Распечатывает список
    public void print(){
        System.out.println("--------------------");
        Note index = currentElement;
        while ( index != null){
            System.out.println("Ячейка [" + index + "] содержит значение - " + index.getVar());
            index = index.getNextAdress();
        }
        System.out.println("--------------------");
    }
    //--------------------------------------------
    //Добавляем элемент в начало листа
    @Override
    public void shift(Object var) {
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
    //--------------------------------------------
    // Удаляем первый элемент в листе
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
    //--------------------------------------------
    // Добавляем элемент в лист по позиции
    @Override
    public void add(Object var, int pos) {
        Note newNote = new Note(var);
        Note index = currentElement;
        if (currentElement == null) {
            newNote.setNextAdress(null);
            newNote.setIndex(0);
            currentElement = newNote;
            return;
        }
        if (pos == 0){
            shift(var);
            return;
        }
        if (pos == currentElement.getIndex()){
            push(var);
            return;
        }
        while (index != null){
            if (pos > 0 && pos < currentElement.getIndex()){
                if (index.getNextAdress().getIndex() == pos){
                    newNote.setNextAdress(index.getNextAdress().getNextAdress());
                    Note newIndex = currentElement;
                    while (newIndex.getIndex() >= pos) {
                        newIndex.setIndex(newIndex.getIndex() + 1);
                        newIndex = newIndex.getNextAdress();
                    }
                    newNote.setIndex(pos);
                    index.getNextAdress().setNextAdress(newNote);
                    break;
                }
            } else {
                System.out.println("Список длинной от 0 до " + currentElement.getIndex() + " элемента. " +
                        "Вставка по позиции " + pos + " невозможна");
            }
            index = index.getNextAdress();
        }
    }
    //--------------------------------------------
    // Удаляем элемент из листа по позиции
    @Override
    public void remove(int pos) {
        Note index = currentElement;
        if ( pos == 0){
            unshift();
            return;
        }
        if (pos == currentElement.getIndex()){
            pop();
            return;
        }
       while (index != null){
           if (pos > 0 && pos < currentElement.getIndex()){
               if (index.getNextAdress().getIndex() == pos){
                   index.setNextAdress(index.getNextAdress().getNextAdress());
                   Note newIndex = currentElement;
                   while (newIndex.getIndex() >= pos) {
                       newIndex.setIndex(newIndex.getIndex() - 1);
                       newIndex = newIndex.getNextAdress();
                   }
                   break;
               }
           } else {
               System.out.println("Лист длиной от 0 до " + currentElement.getIndex() + " элемента. Элемен по позиции " +
                       pos + " удалить нельзя");
           }
           index = index.getNextAdress();
       }
    }
    //--------------------------------------------
    // Возвращаем размер листа
    @Override
    public int size() {
        return currentElement.getIndex() + 1;
    }
    //--------------------------------------------
    // Ищет элемент в листе по индексу
    @Override
    public Object get(int pos) {
        Note index = currentElement;
        Object getElement = null;
        while (index != null){
            if (pos == index.getIndex()){
                getElement = index ;
                break;
            }
            if (pos < 0 || pos > currentElement.getIndex()){
                System.out.println("Лист длиной от 0 до " + currentElement.getIndex() + " элемента. Элемен по позиции " +
                        pos + " не может находиться в листе");
                break;
            }
            index = index.getNextAdress();
        }
        return getElement;
    }

    public Iterator getIterator(){
        return new EvenIterator();
    }

    private class EvenIterator implements Iterator{
        Note index = currentElement;
        @Override
        public boolean hasNext() {
            return  index != null;
        }

        @Override
        public Object next() {
            Note current = index;
            index = index.getNextAdress();
            return current;
        }
    }
}
