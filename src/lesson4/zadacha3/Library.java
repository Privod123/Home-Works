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
                    "Положить в библиотеку " + quantity + " экземпляра " + book.toString() + " - нельзя.");
            return;
        }else {
            for (int i = 1; i <= libraryBook.length; i++) {
                if (quantity > 0 && libraryBook[i - 1] == null ){
                    libraryBook[i - 1] = book;
                    freePlaceInsideLibrary--;
                    quantity--;
                    book.setQuantityBook(1);
                    i =  0;
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
                for (int i = 1; i <= libraryBook.length; i++) {
                    if (libraryBook[i - 1] == null) {
                        continue;
                    }
                    if (quantity > 0 && book.getNameBook().compareTo(libraryBook[i - 1].getNameBook())
                            == book.getAuthorBook().compareTo(libraryBook[i - 1].getAuthorBook())){
                        libraryBook[i - 1] = null;
                        freePlaceInsideLibrary++;
                        book.setQuantityBook(-1);
                        quantity--;
                        i = 0;
                    }
            }
            return freePlaceInsideLibrary;
        }
    }


    //-------------------------------------------------------------
    public void showLibraryFullReference(){
        System.out.println("-----------------------------------");
        System.out.println("В библиотеке лежит :");
        for (int i = 0; i < libraryBook.length; i++) {
            if (libraryBook[i] != null){
                System.out.println(i + 1 + "." + " Книга \"" + libraryBook[i].getNameBook() + "\"."
                        + " Автор - " + libraryBook[i].getAuthorBook());
            } else {
                System.out.println(i + 1  + "." + " Свободное место в библиотеке.");
            }
        }
        System.out.println("-----------------------------------");
    }
    //-------------------------------------------------------------
    public void showLibraryShortReference(){
        System.out.println("-----------------------------------");
        System.out.println("В библиотеке лежит :");
        for (Book book : libraryBook) {
            if (book == null){
                continue;
            } else {
                System.out.println(" - книга \"" + book.getNameBook() + "\" автор - " + book.getAuthorBook()
                        + " в количестве " + book.getQuantityBook() + " шт.");
            }
        }
        System.out.println("-----------------------------------");
    }
}
