package thread.syn.printAbcInOrder;

/**
 * 循环太多，效率低
 */
public class SleepExample extends Thread {

    private static int currentCount = 0;

    public SleepExample(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "===1======" + currentCount);
        while (currentCount < 30) {
            System.out.println(Thread.currentThread().getName() + "===2======" + currentCount);
            switch (currentCount % 3) {
                case 0:
                    if ("A".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 1:
                    if ("B".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
                case 2:
                    if ("C".equals(getName())) {
                        printAndIncrease();
                    }
                    break;
            }
        }

    }

    private void printAndIncrease() {
        print();
        increase();
    }

    private void print() {
        System.out.println(Thread.currentThread().getName() + "--" + getName());
        if ("C".equals(getName())) {
            System.out.println();
        }
    }

    private void increase() {
        currentCount++;
    }

    public static void main(String[] args) {
        new SleepExample("A").start();
        new SleepExample("B").start();
        new SleepExample("C").start();
    }

}