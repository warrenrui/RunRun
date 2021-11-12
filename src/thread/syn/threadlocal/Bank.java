package thread.syn.threadlocal;

public class Bank {
    private int accountInt;
    // 使用ThreadLocal类管理共享变量account
    private static final ThreadLocal<Integer> account = ThreadLocal.withInitial(() -> 0);
    private static final ThreadLocal<String> note = ThreadLocal.withInitial(() -> "新开账户");


    /**
     * threadLocal变量，两个账户的存钱操作并行不悖
     *
     * @param money
     */
    public void saveSyn(int money) {
        System.out.println("存了 " + money + " 个亿");
        account.set(account.get() + money);
        switch (money) {
            case 1:
                note.set("开张啦！");
                break;
            case 2:
                note.set("芝麻开花节节高！");
                break;
            case 3:
                note.set("发展才是硬道理！");
                break;
            default:
                note.set(String.format("钱多到只是个数字而已，又涨了: %s 个亿", money));
        }
    }

    public int getAccountSyn() {
        return account.get();
    }

    public String getNote() {
        return note.get();
    }

    /**
     * 没有同步控制的存钱操作
     *
     * @param money
     */
    public void saveInt(int money) {
        System.out.println("线程共享，随便存了 " + money + " 个亿");
        this.accountInt += money;
    }

    public int getAccountInt() {
        return this.accountInt;
    }

}
