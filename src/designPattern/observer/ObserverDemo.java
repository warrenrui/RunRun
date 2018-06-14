package designPattern.observer;


public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new OctalObserver(subject);
        new DecimalObserver(subject);

        subject.setState(12);
    }
}
