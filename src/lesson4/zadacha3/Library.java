package lesson4.zadacha3;

import java.util.Arrays;

public class Library {

    private int freePlaceInsideLibrary = 10;
    private Book[] libraryBook = new Book[freePlaceInsideLibrary];
    //-------------------------------------------------------------
    public void put(Book book, int quantity){
        if (freePlaceInsideLibrary == 0){
            System.out.println("Мест нет,библиотека заполнена.");

        } else if (freePlaceInsideLibrary < quantity){
            System.out.println("В библиотке свободно - " + freePlaceInsideLibrary + " места. " +
                    "Положить в библиотеку " + quantity + " экземпляра " + book.toString() + " - недьзя.");
            return;
        }else {
            label : for (int k = quantity; k > 0 ; k--) {
                for (int i = 0; i < libraryBook.length; i++) {
                    if (libraryBook[i] == null){
                        libraryBook[i] = book;
                        freePlaceInsideLibrary--;
                        for (int j = 0; j < libraryBook.length; j++) {
                            if (book.getNameBook().equals(libraryBook[i].getNameBook())
                                    && book.getAuthorBook().equals(libraryBook[i].getAuthorBook()));{
                                book.setQuantityBook(1);
                                continue label;
                            }
                        }
                        continue label;
                    }
                }
            }
        }
    }
    //-------------------------------------------------------------
    public int get(Book book, int quantity){
        if (book.getQuantityBook() == 0){
            System.out.println("В библиотке нет " + book.toString());
            return freePlaceInsideLibrary;
        } else if (book.getQuantityBook() < quantity){
            System.out.println("В библиотке осталось только - " + book.getQuantityBook() + " экземпляров. Будете брать ?");
            return freePlaceInsideLibrary;
        } else {
            label : for (int i = quantity; i > 0 ; i--) {
                for (int j = 0; j < libraryBook.length; j++) {
                    if (libraryBook[j] == null) {
                        continue ;
                    }
                    if (book.getNameBook().compareTo(libraryBook[j].getNameBook())
                            == book.getAuthorBook().compareTo(libraryBook[j].getAuthorBook())){
                        libraryBook[j] = null;
                        freePlaceInsideLibrary++;
                        book.setQuantityBook(-1);
                        continue label;
                    }
                }
            }
            return freePlaceInsideLibrary;
        }
    }
    //-------------------------------------------------------------
    public void showLibrary(){
        System.out.println("В библиотеке лежит :");
        for (int i = 0; i < libraryBook.length; i++) {
            if (libraryBook[i] != null){
                System.out.println(i + 1 + "." + " Книга \"" + libraryBook[i].getNameBook() + "."
                        + " Автор - " + libraryBook[i].getAuthorBook());
            } else {
                System.out.println(i + 1  + "." + " Свободное место в библиотеке.");
            }
        }
    }
}
