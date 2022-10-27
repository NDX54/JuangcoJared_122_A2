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
        this.sc = ShapeColor.Green;
        this.a = 5;
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
        this.sc = ShapeColor.Green;
        this.a = 10;
        this.b = 10;
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
        double lengthPlusWidth = getA() + getB();
        return 2 * lengthPlusWidth;
    }

    @Override
    public double area() {
        return getA() * getB();
    }

    public void set(ShapeColor sc, int length, int width) {
        this.sc = sc;
        this.a = length;
        this.b = width;
    }

    @Override
    public String toString() {
        return "Rectangle (2D (" + getShapeColor() + ", " + getA() + ", " + getB() + "))";
    }
}

class Triangle extends TwoD {

    public Triangle() {
        this.sc = ShapeColor.Red;
        this.a = 5;
        this.b = 5;
        this.c = 5;
    }

    public Triangle(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(Triangle t) {
        this(t.sc, t.a, t.b, t.c);
    }

    @Override
    public double perimeter() {
        return getA() + getB() + getC();
    }

    @Override
    public double area() {
        // Finding the area using Heron's formula
        double S = (getA() + getB() + getC()) / 2.0;
        return Math.sqrt(S * (S - getA()) * (S - getB()) * (S - getC()));
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

    public void set(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle (2D (" + getShapeColor() + ", " + getA() + ", " + getB() + ", " + getC() + "))";
    }
}

class Trapezoid extends TwoD {

    private int h;

    public Trapezoid() {
        this.sc = ShapeColor.Yellow;
        this.a = 5;
        this.b = 5;
        this.c = 5;
        this.d = 5;
        this.h = 10;
    }

    public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
    }

    public Trapezoid(Trapezoid t) {
        this(t.sc, t.a, t.b, t.c, t.d, t.h);
    }

    @Override
    public double perimeter() {
        return getA() + getB() + getC() + getD();
    }

    @Override
    public double area() {
        double aPlusBDivTwo = (getA() + getB()) / 2.0;
        return aPlusBDivTwo * getHeight();
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

    public int getHeight() {
        return h;
    }

    public void set(ShapeColor sc, int a, int b, int c, int d, int h) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Trapezoid (2D (" + getShapeColor() + ", " + getA() + ", " + getB()
                + ", " + getC() + ", " + getD() + "))";
    }
}

class Cube extends ThreeD {

    public Cube() {
        this.sc = ShapeColor.Green;
        this.a = 5.0;
    }

    public Cube(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public Cube(Cube c) {
        this(c.sc, c.a);
    }

    @Override
    public double volume() {
        return Math.pow(getA(), 3);
    }

    @Override
    public double area() {
        return 6.0 * Math.pow(getA(), 2);
    }

    double getA() {
        return a;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return "Cube (3D (" + this.sc + ", " + getA() + "))";
    }
}

class Tetrahedron extends ThreeD {

    public Tetrahedron() {
        this.sc = ShapeColor.Blue;
        this.a = 5;
    }

    public Tetrahedron(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public Tetrahedron(Tetrahedron t) {
        this(t.sc, t.a);
    }

    @Override
    public double volume() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return "Tetrahedron (3D (" + this.sc + ", " + getA() + "))";
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
        Rectangle testRectangle = new Rectangle(ShapeColor.Red, 14, 9);
        Triangle testTriangle = new Triangle(ShapeColor.Yellow, 3,6,7);
        Trapezoid testTrapezoid = new Trapezoid(ShapeColor.Green,12,12,12,12,16);
        Cube testCube = new Cube(ShapeColor.Blue, 12.0);

        System.out.println(testCircle);
        System.out.println(testCircle.area());
        System.out.println(testCircle.perimeter());
        System.out.println(testRectangle);
        System.out.println(testRectangle.perimeter());
        System.out.println(testRectangle.area());
        System.out.println(testTriangle);
        System.out.println(testTriangle.perimeter());
        System.out.println(testTriangle.area());
        System.out.println(testTrapezoid);
        System.out.println(testTrapezoid.perimeter());
        System.out.println(testTrapezoid.area());
        System.out.println(testCube);
        System.out.println(testCube.area());
        System.out.println(testCube.volume());
    }
}
