package lessons6;

import lessons6.zadacha1.*;

import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.push(1);
        myLinkedList.push(2);
        myLinkedList.push(3);

        myLinkedList.print();
//        myLinkedList.shift(1);
//        myLinkedList.shift(2);
        myLinkedList.shift(3);
        myLinkedList.print();

        myLinkedList.push(5);
        myLinkedList.print();

        myLinkedList.pop();
        myLinkedList.print();

        myLinkedList.unshift();
        myLinkedList.print();
//
//        myLinkedList.pop();
//        myLinkedList.print();
    }
}
