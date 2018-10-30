package lessons6;

import lessons6.zadacha1.*;

import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.push(new Integer(1));
        myLinkedList.push(new Integer(2));
        myLinkedList.push(new Integer(3));

        myLinkedList.print();

        myLinkedList.shift(new Integer(3));
        myLinkedList.print();

        myLinkedList.push(new Integer(5));
        myLinkedList.print();

        myLinkedList.pop();
        myLinkedList.print();

        myLinkedList.unshift();
        myLinkedList.print();

    }
}
