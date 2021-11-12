package thread.syn.threadlocal;

public class testThreadLocal {
    public static void main(String[] args) {
        Bank bank = new Bank();
        LockRunner1 lockRunner1 = new LockRunner1(bank);
        LockRunner1 lockRunner2 = new LockRunner1(bank);
        lockRunner1.start();
        lockRunner2.start();
    }
}

class LockRunner1 extends Thread {

    private final Bank bank;

    LockRunner1(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 1; i <= 52; i++) {
            System.out.println(Thread.currentThread().getName() + "----- ----- " + i);

            bank.saveSyn(i);
            bank.saveInt(i);
            System.out.println(Thread.currentThread().getName() +
                    "----- 线程隔离金额：" + bank.getAccountSyn() +
                    "----- 线程共享金额：" + bank.getAccountInt() +
                    "----- 线程隔离备注： " + bank.getNote());
        }
    }
}
