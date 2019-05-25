package xyz.thishome.test;

public class TestInterface {

    public static void main(String[] args) {
        Square square = new Square();
        Circle circle = new Circle();

        method(square);
        method(circle);
    }

    public static void method(Shape shape){
        shape.draw();
        shape.destroy();
    }

}

interface Shape{
    void draw();
    void destroy();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("draw of square . . . ");
    }

    @Override
    public void destroy() {
        System.out.println("destroy of square . . . ");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("draw of circle . . . ");
    }

    @Override
    public void destroy() {
        System.out.println("destroy of circle . . . ");
    }
}