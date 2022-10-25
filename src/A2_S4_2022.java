enum ShapeColor {
    Blue,
    Yellow,
    Red,
    Green,
    White;
}

interface ForTwoD {
    double perimeter();
    void recolor(ShapeColor sc);
}

interface ForThreeD {

    double volume();
    void resize(double percentage);
}

interface Shape {
    double pi = Math.PI;
    double area();
}


abstract class TwoD implements ForTwoD, Shape {
    protected ShapeColor sc;
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    public TwoD() {

    }

    public TwoD(ShapeColor sc, int a) {
        this.sc = sc;
        this.a = a;
    }

    public TwoD(ShapeColor sc, int a, int b) {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public TwoD(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public TwoD(ShapeColor sc, int a, int b, int c, int d) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public TwoD(TwoD td) {
        this(td.sc, td.a, td.b, td.c, td.d);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public ShapeColor getShapeColor() {
        return sc;
    }

    public void set(ShapeColor sc, int a) {
        this.sc = sc;
        this.a = a;
    }

    public void set(ShapeColor sc, int a, int b) {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public void set(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set(ShapeColor sc, int a, int b, int c, int d) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void recolor(ShapeColor sc) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}

abstract class ThreeD implements  ForThreeD, Shape {
    protected ShapeColor sc;
    protected double a;


    public ThreeD() {

    }

    public ThreeD(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public ThreeD(ThreeD td) {
        this(td.sc, td.a);
    }

    double getA() {
        return a;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public void resize(double percentage) {


    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Circle extends TwoD {

    public Circle() {

    }

    public Circle(ShapeColor sc, int radius) {
        this.sc = sc;
        this.a = radius;
    }

    public Circle(Circle c) {
        this(c.sc, c.a);
    }

    public int getRadius() {
        return getA();
    }

    @Override
    public double perimeter() {
        return 2 * pi * getRadius();
    }

    @Override
    public double area() {
        double radiusSquared = Math.pow(getRadius(), 2);
        return pi * radiusSquared;
    }

    public void set(ShapeColor sc, int radius) {
        this.sc = sc;
        this.a = radius;
    }

    @Override
    public String toString() {
        return "Circle (2D (" + getShapeColor() + ", " + getRadius() + "))";
    }
}

class Rectangle extends TwoD {

    public Rectangle() {

    }

    public Rectangle(ShapeColor sc, int length, int width) {
        this.sc = sc;
        this.a = length;
        this.b = width;
    }

    public Rectangle(Rectangle r) {
        this(r.sc, r.a, r.b);
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public void recolor(ShapeColor sc) {

    }

    @Override
    public double area() {
        return 0;
    }
}

class Triangle extends TwoD {

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }
}

class Trapezoid extends TwoD {

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }
}


public class A2_S4_2022 {
    private static int getInt() {
        return 0;
    }

    private static double getDouble() {
        return 0.0;
    }

    private static ShapeColor getColor() {
        return ShapeColor.Green;
    }

    private static boolean isTriangle(int a, int b, int c) {
        if (a != 0 && b != 0 && c != 0) {
            return true;
        } else  {
            return false;
        }
    }
    public static void main(String[] args) {
        Circle testCircle = new Circle(ShapeColor.Blue, 12);

        System.out.println(testCircle);
        System.out.println(testCircle.area());
        System.out.println(testCircle.perimeter());
    }
}
