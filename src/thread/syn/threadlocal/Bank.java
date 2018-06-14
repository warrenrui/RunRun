package thread.syn.threadlocal;

public class Bank {
    private int accountInt;
    // 使用ThreadLocal类管理共享变量account
    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    /**
     * threadLocal变量，两个账户的存钱操作并行不悖
     *
     * @param money
     */
    public void saveSyn(int money) {
        System.out.println("存了 " + money + " 钱");
        account.set(account.get() + money);
    }

    public int getAccountSyn() {
        return account.get();
    }

    /**
     * 没有同步控制的存钱操作
     *
     * @param money
     */
    public void saveInt(int money) {
        System.out.println("存了 " + money + " 钱");
        this.accountInt += money;
    }

    public int getAccountInt() {
        return this.accountInt;
    }

}