package designPattern.observer;


public class DecimalObserver extends Observer {
    DecimalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("十进制 Decimal String " + Integer.toString(this.subject.getState()));
    }

}
