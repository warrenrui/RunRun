package jvm;

/**
 * VM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M -Xss1024k
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * Xss设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。
 * 根据应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。
 * 但是操作系统对一个进程内的线程数还是有限制的， 不能无限生成，经验值在3000~5000左右。
 *
 * <ol>
 * <li>-Xss128k，stackLength：987
 * <li>-Xss256k，stackLength：2842
 * <li>-Xss512k，stackLength：8851
 * <li>-Xss1024k，stackLength：18796/19301
 * </ol>
 *
 * @author xxr
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length：" + oom.stackLength);
            throw e;
        }
    }
}
