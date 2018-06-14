package designPattern.factory.abstractt;

import designPattern.factory.simple.color.Color;
import designPattern.factory.simple.color.Green;
import designPattern.factory.simple.color.Red;
import designPattern.factory.simple.shape.Shape;

public class ColorFactory extends AbstractFactory {
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("red")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("green")) {
            return new Green();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
