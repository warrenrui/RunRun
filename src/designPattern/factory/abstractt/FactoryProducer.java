package designPattern.factory.abstractt;

public class FactoryProducer {
    AbstractFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("color")) {
            return new ColorFactory();
        } else if (factoryType.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        }
        return null;
    }
}
