package designPattern.factory.simple.shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("画个四方形");
    }

}
