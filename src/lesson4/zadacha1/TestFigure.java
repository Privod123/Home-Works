package lesson4.zadacha1;
/*
Создайте фигуры: Circle,Rectangle,Triagle, у которых будут координаты. Все фигуры должны иметь методы которые
возвращают площадь и периметр(для окружности - длина окружности).
 */

public class TestFigure {
    public static void main(String[] args) {
        System.out.println("");
        Figure circle = new Figure(2);
        System.out.println("Площадь круга - " + circle.getSquareCircle());
        System.out.println("Периметр круга - " + circle.getPerimeterCircle());
        System.out.println("--------------------------------------");
        Figure rectangle = new Figure(2,3);
        System.out.println("Площадь прямоугольника - " + rectangle.getSquareRectangle());
        System.out.println("Периметр прямоугольника - " + rectangle.getPerimeterRectangle());
        System.out.println("--------------------------------------");
        Figure triagle = new Figure(3,4,5);
        System.out.println("Площадь треугольника - " + triagle.getSquareTriagle());
        System.out.println("Периметр треугольника - " + triagle.getPerimeterTriagle());

        }
}
