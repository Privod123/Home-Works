package lesson4.zadacha3;

public class Book {
    private String nameBook;
    private String authorBook;
    private int quantityBook;

    public Book(String nameBook, String authorBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setQuantityBook(int quantity) {
        this.quantityBook = this.quantityBook + quantity;
    }

    public int getQuantityBook() {
        return quantityBook;
    }

    @Override
    public String toString() {
        return "книга = '" + nameBook + '\'' +
                ", автор =' " + authorBook + '\'' ;
    }
}
