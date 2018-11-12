package grammar.lambda;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    /**
     * Lambda表达式的语法
     * 基本语法:
     * (parameters) -> expression
     * 或
     * (parameters) ->{ statements; }
     * <p>
     * // 1. 不需要参数,返回值为 5
     * () -> 5
     * <p>
     * // 2. 接收一个参数(数字类型),返回其2倍的值
     * x -> 2 * x
     * <p>
     * // 3. 接受2个参数(数字),并返回他们的差值
     * (x, y) -> x – y
     * <p>
     * // 4. 接收2个int型整数,返回他们的和
     * (int x, int y) -> x + y
     * <p>
     * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     * (String s) -> System.out.print(s)
     */

    public static void main(String[] args) {

        /**
         * for 循环
         */
        List<String> slogans = Arrays.asList("for the horde", "may the force be with you","fighter");
        for (String slogan : slogans) {
            System.out.println(slogan);
        }
        slogans.forEach((slogan) -> System.out.println(slogan + ","));
        slogans.forEach(System.out::println);

        final List<List<String>> partition = Lists.partition(slogans, 2);

        /**
         * 匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run!");
            }
        }).start();
        new Thread(() -> System.out.println("run!")).start();


        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run!");
            }
        };
        runnable.run();
        final Runnable runnable1 = () -> System.out.println("run!");
        runnable1.run();


        /**
         * 使用lambda排序集合
         */
        String[] players = {"John", "Tom", "Warren", "Lucy"};
        System.out.println("排序前：" + Arrays.toString(players));
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Arrays.sort(players, (o1, o2) -> o1.compareTo(o2));
        Arrays.sort(players, String::compareTo);
        Arrays.sort(players, Comparator.naturalOrder());
        System.out.println("排序后：" + Arrays.toString(players));

    }
}
