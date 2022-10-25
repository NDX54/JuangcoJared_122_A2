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
}

abstract class ThreeD implements  ForThreeD, Shape {
    protected ShapeColor sc;
    protected double a;

}


public class A2_S4_2022 {

}
