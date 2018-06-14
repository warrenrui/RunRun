package designPattern.proxy.image;

public class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (null == realImage) {
            this.realImage = new RealImage(this.fileName);
        }
        realImage.display();
    }

}
