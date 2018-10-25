package lesson1;

/*
Найдите площадь овального кольца,полученного из овала площадью 15 дм2 вырезанием овала площадью 600 см2
 */

public class Zadacha_3 {
    public static void main(String[] args) {
        int squareBigOval = 15;
        int squareCutOval = 600;
        //привидем площади к одной системе измерений (м2)
        double squareBigOvalMetr = squareBigOval * 0.01;
        double squareCutOvalMetr = squareCutOval * 0.0001;
        //получем площадь получивщегося овального кольца
        double squareNewOvalMetr = squareBigOvalMetr - squareCutOvalMetr;
        System.out.println("Площадь нового овального кольца : " + squareNewOvalMetr + " м2 ");
        System.out.println("Площадь нового овального кольца : " + (int)(squareNewOvalMetr * 100) + " дм2 ");
        System.out.println("Площадь нового овального кольца : " + (int)(squareNewOvalMetr * 10000) + " см2 ");
    }
}
