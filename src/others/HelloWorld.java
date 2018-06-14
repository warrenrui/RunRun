package others;

public class HelloWorld {

    static boolean aaaa;

    // main主方法是测试用的执行入口
    public static void main(String[] args) {
        int age = 18;
        String name = "小明";
        long num = 90;
        float f = 90.00f;
        double d = 90.02;
        //长整型类型
        long num1 = age;
        //整形类型
        int age2 = (int) d;

        double d2 = age;
        System.out.println(d2);
        System.out.println(d);

        System.out.println((int) d);

        age2 = 1;
        System.out.println(age2);

        //		90.02  精确度损失
        //		90

        int age1 = (int) num;

        int a = 20;
        long b = a;

        long aa = 10;
        int bb = (int) aa;

        // 范围大的数据类型，就相当于这个变量a，有个大房子；
        //		范围小的数据类型，相当于这个变量b，有个小房子；
        //		想让a住b的小房子，肯定不乐意，必须强制转换才行
        //		想让b住啊的大房子，肯定乐意，不需要强制转换

        // true代表吃饱了，false代表没吃饱
        boolean aaaaa = true;

        boolean isEatFull = true;// 代码可读性，代码即注释

        //		aaaa = false;

        //		System.out.println(age + name);

        int account = 10;
        //第一天，花了两块钱
        account = account - 2;
        System.out.println(account);//8
        // 第二天，我挣了十块钱
        account = account + 10;
        System.out.println(account);//18
        // 第三天，我学成了编程，工资翻倍
        account = account * 2;
        System.out.println(account);//36

        System.out.println(aaaa);
        // 下雨了么？
        // 上午，出门的时候，下雨了，true
        boolean isRain = true;
        // 下午，我从网吧回来，雨停了，false
        isRain = false;
        // 晚上有夜班，我去不去？看看下不下雨
        if (isRain) {
            System.out.println("下雨了，今天不去上班");
        } else {
            System.out.println("没下雨，照常上班");
        }

        // 三目运算符
        String string1111 = isRain ? "下雨了，今天不去上班" : "没下雨，照常上班";
        System.out.println(string1111);

        String jintianchisha = account > 100 ? "吃肉" : "吃糠";
        System.out.println(jintianchisha);

        int age10 = 12;
        String play = age10 >= 12 ? "可以玩王者荣耀" : "不可以玩王者荣耀";
        System.out.println(play);

        // boolean true,false ;  age10 > 10 ——true , age10> 14 ——false
        int age_1 = 0;

        age_1 = 18;
        age_1 = 1;
        age_1 = 13;

        System.out.println(age_1 >= 12);

        if (age_1 >= 12) {
            System.out.println("可以玩王者荣耀");
        } else {
            System.out.println("不可以玩王者荣耀");
        }

        int tomHeight = 18;
        int jerryHeight = 170;
//		boolean isTomHigher;
//		// 通过比较，得出结果，用boolean类型存储，正确/对/true，错误/错/false
//		isTomHigher = tomHeight > jerryHeight;
//		System.out.println(isTomHigher);
        System.out.println(tomHeight > jerryHeight);

    }

}
