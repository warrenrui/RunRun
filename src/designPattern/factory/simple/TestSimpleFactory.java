package designPattern.factory.simple;

import designPattern.factory.simple.color.Color;
import designPattern.factory.simple.color.ColorFactory;
import designPattern.factory.simple.shape.Shape;
import designPattern.factory.simple.shape.ShapeFactory;

public class TestSimpleFactory {
    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        Shape shape = sf.getShape("circle");
        shape.draw();
        shape = sf.getShape("rectangle");
        shape.draw();

        ColorFactory cf = new ColorFactory();
        Color color = cf.getColor("red");
        color.fill();
        color = cf.getColor("green");
        color.fill();
    }
}
