package lesson4.zadacha1;

public class Figure {
    final double pi = 3.14;
    private double radiys;
    private double sideA;
    private double sideB;
    private double sideC;
    private double squareCircle;
    private double perimeterCircle;
    private double squareRectangle;
    private double perimeterRectangle;
    private double squareTriagle;
    private double perimeterTriagle;

    public Figure(double radiys) {
        this.radiys = radiys;
    }

    public Figure(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Figure(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSquareCircle() {
        return pi*Math.pow(radiys,2);
    }

    public double getPerimeterCircle() {
        return 2*pi*radiys;
    }

    public double getSquareRectangle() {
        return sideA * sideB;
    }

    public double getPerimeterRectangle() {
        return 2*(sideA + sideB);
    }

    public double getSquareTriagle() {
        double p = (sideA + sideB + sideC)/2;
        return Math.sqrt(p*(p - sideA)*(p - sideB)*(p - sideC));
    }

    public double getPerimeterTriagle() {
        return sideA + sideB + sideC;
    }
}
