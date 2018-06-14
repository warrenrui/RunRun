package designPattern.factory.abstractt;

import designPattern.factory.simple.color.Color;
import designPattern.factory.simple.shape.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
