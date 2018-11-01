package lessons6;

import lessons6.zadacha1.*;

import java.util.Iterator;
import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        // Добавляем в конец листа
        myLinkedList.push(new Integer(1));
        myLinkedList.push(new Integer(2));
        myLinkedList.push(new Integer(3));

//        myLinkedList.print();
        // Добавляем в начало листа
        myLinkedList.shift(new Integer(5));

//        myLinkedList.print();
        // Добавляем по позиции
        myLinkedList.add(new Integer(8),2);

        myLinkedList.print();

        myLinkedList.remove(2);
        myLinkedList.print();

        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.size());

        myLinkedList.print();

        Iterator iterator = myLinkedList.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
