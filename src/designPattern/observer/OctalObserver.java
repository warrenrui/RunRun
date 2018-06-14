package designPattern.observer;


public class OctalObserver extends Observer {
    OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("八进制 Octal String " + Integer.toOctalString(this.subject.getState()));
    }

}
