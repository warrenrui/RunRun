package designPattern.factory.abstractt;

import designPattern.factory.simple.color.Color;
import designPattern.factory.simple.shape.Shape;

public class TestNormalFactory {
    public static void main(String[] args) {
        FactoryProducer fp = new FactoryProducer();
        AbstractFactory sf = fp.getFactory("shape");
        Shape shape = sf.getShape("circle");
        shape.draw();
        shape = sf.getShape("rectangle");
        shape.draw();

        AbstractFactory cf = fp.getFactory("color");
        Color color = cf.getColor("red");
        color.fill();
        color = cf.getColor("green");
        color.fill();
    }
}
