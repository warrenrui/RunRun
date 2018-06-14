package designPattern.factory.abstractt;

import designPattern.factory.simple.color.Color;
import designPattern.factory.simple.shape.Circle;
import designPattern.factory.simple.shape.Rectangle;
import designPattern.factory.simple.shape.Shape;

public class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }

    @Override
    Color getColor(String color) {
        return null;
    }
}
