import java.util.*;

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
    String getName();
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
        this.sc = sc;
    }

    @Override
    public String toString() {

        if (this.sc != null && this.a != 0 && this.b == 0 && this.c == 0 && this.d == 0) {
            // Circle
            return "(2D (" + getShapeColor() + ", " + getA() + "))";
        } else if (this.sc != null && this.a != 0 && this.b != 0 && this.c == 0 && this.d == 0) {
            // Rectangle
            return "(2D (" + getShapeColor() + ", " + getA() + ", " + getB() + "))";
        } else if (this.sc != null && this.a != 0 && this.b != 0 && this.c != 0 && this.d == 0) {
            // Triangle
            return "(2D (" + getShapeColor() + ", " + getA() + ", " + getB() + ", " + getC() + "))";
        } else {
            return "(2D ())";
        }
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

    ShapeColor getShapeColor() {
        return sc;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public void resize(double percentage) {
        double percentDivided = percentage / 100;
        this.a = a * (1 - percentDivided);
    }

    @Override
    public String toString() {
        String formattedDecimalValue = String.format("%.3f", getA());
        return "(3D (" + getShapeColor() + ", " + formattedDecimalValue + "))";
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

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public void set(ShapeColor sc, int radius) {
        this.sc = sc;
        this.a = radius;
    }

    @Override
    public String toString() {
        return "Circle " + super.toString();
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

    @Override
    public String getName() {
        return "Rectangle";
    }

    public void set(ShapeColor sc, int length, int width) {
        this.sc = sc;
        this.a = length;
        this.b = width;
    }

    @Override
    public String toString() {
        return "Rectangle " + super.toString();
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

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getC() {
        return c;
    }

    @Override
    public void set(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle " + super.toString();
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

    @Override
    public String getName() {
        return "Trapezoid";
    }

    @Override
    public int getA() {
        return a;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getC() {
        return c;
    }

    @Override
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
//        return "Trapezoid " + super.toString();
        return "Trapezoid (2D (" + getShapeColor() + ", " + getA() + ", " + getB() + ", " + getC() + ", " + getD() + "), " + getHeight() + ")";
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

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    double getA() {
        return a;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return "Cube " + super.toString();
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
        double aCubed = Math.pow(getA(), 3);
        double sixSquareRootTwo = 6 * Math.sqrt(2);
        return (aCubed) / (sixSquareRootTwo);
    }

    @Override
    public double area() {
        return Math.sqrt(3) * Math.pow(getA(), 2);
    }

    @Override
    public String getName() {
        return "Tetrahedron";
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
        return "Tetrahedron " + super.toString();
    }
}

class Sphere extends ThreeD {

    public Sphere() {
        this.sc = ShapeColor.White;
        this.a = 12;
    }

    public Sphere(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public Sphere(Sphere s) {
        this(s.sc, s.a);
    }

    @Override
    double getA() {
        return a;
    }

    @Override
    public double volume() {
        double fourPiRadiusCubed = 4 * pi * Math.pow(getA(), 3);
        return fourPiRadiusCubed / 3;
    }

    @Override
    public double area() {
        return 4 * pi * Math.pow(getA(), 2);
    }

    @Override
    public String getName() {
        return "Sphere";
    }

    @Override
    public String toString() {
        return "Sphere " + super.toString();
    }
}


public class A2_S4_2022 {
    private static int getInt() {
        Random rand = new Random();
        return rand.nextInt(1, 10);
    }

    private static double getDouble() {
        Random rand = new Random();
        return rand.nextDouble(1.0, 10.0);
    }

    private static ShapeColor getColor() {
        Random rand = new Random();
        int randInt = rand.nextInt(0, ShapeColor.values().length);
        return ShapeColor.values()[randInt];
    }

    private static boolean isTriangle(int a, int b, int c) {
        double hypotenuseSquared = Math.pow(c, 2);
        double altitudeSquared = Math.pow(a, 2);
        double baseSquared = Math.pow(b, 2);
        if (a >= (b + c) || c >= (b + a) || b >= (a + c)) {
            // Not a triangle
            return false;
        } else if (a == b && b == c) {
            // Equilateral triangle
            return true;
        } else if ((altitudeSquared + baseSquared) == hypotenuseSquared || (altitudeSquared + hypotenuseSquared) == baseSquared ||
                (hypotenuseSquared + baseSquared) == altitudeSquared) {
            // Right triangle
            return true;
        } else if (a != b && b != c && c != a) {
            // Scalene triangle
            return true;
        } else {
            // Isosceles triangle
            return true;
        }
    }

    private static TwoD getTwoD() {
        Random rand = new Random();

        List<TwoD> twoDShapes = Arrays.asList(
                new Circle(getColor(), getInt()),
                new Rectangle(getColor(), getInt(), getInt()),
                new Triangle(getColor(), getInt(), getInt(), getInt()),
                new Trapezoid(getColor(), getInt(), getInt(), getInt(), getInt(), getInt())
        );

        int randIndex = rand.nextInt(0, twoDShapes.size());

        return twoDShapes.get(randIndex);
    }

    private static ThreeD getThreeD() {
        Random rand = new Random();

        List<ThreeD> threeDShapes = Arrays.asList(
                new Cube(getColor(), getDouble()),
                new Sphere(getColor(), getDouble()),
                new Tetrahedron(getColor(), getDouble())
        );
        int randIndex = rand.nextInt(0, threeDShapes.size());

        return threeDShapes.get(randIndex);
    }

    private static void process2DShape(Shape ss) {
        TwoD shape = ((TwoD) ss);
        shape.sc = getColor();
        if (isTriangle(shape.getA(), shape.getB(), shape.getC())) {
            System.out.printf("Updated color: %s\nArea = %.3f\nI am a %s shape with color changed to %s\n",
                    shape.getShapeColor(),
                    shape.area(),
                    shape.getName(),
                    shape.getShapeColor());
        } else {
            shape.a = 5;
            shape.b = 5;
            shape.c = 5;
            System.out.printf("Updated color: %s\nArea = %.3f\nI am a %s shape with color changed to %s\n",
                    shape.getShapeColor(),
                    shape.area(),
                    shape.getName(),
                    shape.getShapeColor());
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    private static void process3DShape(Shape ss) {
        ThreeD shape = ((ThreeD) ss);
        double resizePercent = getDouble();
        System.out.printf("Surface area = %.3f\nVolume = %.3f\n", shape.area(), shape.volume());
        shape.resize(resizePercent);
        System.out.printf("Size reduced by %.1f%%: %s\nUpdated surface area = %.3f\nUpdated volume = %.3f\n",
                resizePercent,
                shape,
                shape.area(),
                shape.volume());
        System.out.println("I am a " + shape.getName() + " shape");
        System.out.println("-----------------------------------------------------------------------");
    }

    private static void displayList(ArrayList<Shape> alist) {
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < alist.size(); i++) {
            System.out.println("Shape " + (i+1) + ": " + alist.get(i));
            if (alist.get(i) instanceof TwoD) {
                process2DShape(alist.get(i));
            } else {
                process3DShape(alist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Shape> shapes = new ArrayList<>();

        int k = 2;

        while (k != 0) {
            k = rand.nextInt(0,2);
            if (k == 1) {
                shapes.add(getTwoD());
            } else {
                shapes.add(getThreeD());
            }
        }

        displayList(shapes);

    }
}
