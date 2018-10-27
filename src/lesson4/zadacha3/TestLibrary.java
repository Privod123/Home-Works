package lesson4.zadacha3;

public class TestLibrary {
    public static void main(String[] args) {
        // Создаем книги

        Book book1 = new Book("Бессмертники", "Хлоя Бенджамин");
        Book book2 = new Book("Сделай сам", "Рамзес Хуба");
        Book book3 = new Book("Очерки жизни Спанч Боба", "Спанч Боб");
        Book book4 = new Book("Война и Мир", "Лев Толстой");
        Book book5 = new Book("Теория струн", "Шелдон Купер");

        // Пытаемся положить книги в библиотеку

        Library library = new Library();
        library.put(book1,1);
        library.put(book2,1);
        library.put(book3,1);
        library.put(book4, 4);

//        library.showLibraryShortReference();
        library.showLibraryFullReference();

        // Забираем книгу из библиотеки

//        System.out.println("В библиотеке свободно - " + library.get(book5,2) + " места.");
//        System.out.println("В библиотеке свободно - " + library.get(book4,2) + " места.");
//
//         library.showLibraryFullReference();
//         library.showLibraryShortReference();


    }

}
