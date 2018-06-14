package designPattern.factory.simple.color;

public class ColorFactory {
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
}
