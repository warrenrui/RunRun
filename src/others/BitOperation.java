package others;

public class BitOperation {
    public static void main(String[] args) {
        System.out.println("====一、位操作基础");
        System.out.println("-------①位操作符的运算优先级比较低");
        System.out.println(4 << 2 + 1);
        System.out.println((4 << 2) + 1);
        System.out.println("-------②位操作只能用于整形数据，对float和double类型进行位操作会被编译器报错");
        float i = 3.14f;
        double j = 3.14;
        // System.out.println(i << 2);
        // System.out.println(j << 2);
        System.out.println("-------③算术位移和逻辑位移");
        // 对于移位操作，在微软的VC6.0和VS2008编译器都是采取算术移位即算术移位操作.
        // 算术移位是相对于逻辑移位，它们在左移操作中都一样，低位补0即可，但在右移中逻辑移位的高位补0，而算术移位的高位是补符号位。如下面代码会输出3和-4。
        int a = 15, b = -15;
        System.out.println(a >> 2);
        System.out.println(b >> 2);
        // 因为15=0000 1111(二进制)，右移二位，最高位由0填充将得到0000 0011，即3。
        // -15 = 1111 0001(二进制)，右移二位，最高位由符号位填充将得到1111 1100，取反加一，即-4。
        // int类型一般占4字节，32位。因此15准确表达为15=00000000 00000000 00000000 00001111(二进制)
        // -15准确表达为-15=11111111 11111111 11111111 11110001(二进制)。
        // 为了简便起见，文章中使用15=00001111(二进制)，-15=11110001(二进制)。
        System.out.println("-------④逻辑运算符");
        // 位操作还有一些复合操作符，如&=、|=、 ^=、<<=、>>= 与 += 类似
        // 逻辑与运算 & 同为1才是1；逻辑或运算 | 同为0才是0.
        // 5 = 00000000 00000000 00000000 00000101
        // 2 = 00000000 00000000 00000000 00000010
        int k = 5;
        System.out.println(k & 2);// 0
        System.out.println(k | 2);// 7
        System.out.println(k ^ 2);// 7 异或，不一样才是1
        System.out.println(k << 2);// 20
        System.out.println(k >> 2);// 1
        System.out.println(~k);// -6 取反
        // 无符号移动
        System.out.println(-4321 >>> 30);// 3
        System.out.println(-4321 >> 30);// -1

        System.out.println("=============二、常用位操作小技巧");
        System.out.println("-------①判断奇偶");
        // 输出0到10之间的所有奇数。只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) ==
        // 0)代替if (a % 2 == 0)来判断a是不是偶数。
        for (int k2 = 0; k2 < 10; k2++) {
            if (k2 % 2 == 0) {
                System.out.print(k2 + " ");
            }
            if ((k2 & 1) == 0) {
                System.out.print(k2 + " ");
            }
        }
        System.out.println();
        System.out.println("-------②交换两数而不用第三方变量");
        int aa = 23, bb = 34;
        aa ^= bb;
        bb ^= aa;
        aa ^= bb;
        System.out.println(aa + " " + bb);
        aa = 23;
        bb = 34;
        aa = aa + bb;
        bb = aa - bb;
        aa = aa - bb;
        System.out.println(aa + " " + bb);
        System.out.println("-------③变换符号");
        int cc = -123, dd = 234;
        System.out.println(~cc + 1 + " " + (~dd + 1));
        System.out.println(~cc + 1 + " " + ~dd + 1 + " 注意运算优先级");
        System.out.println("-------④求绝对值");
        // 先移位来取符号位，int i = a >> 31;要注意如果a为正数，i等于0，为负数，i等于-1。
        // 然后对i进行判断——如果i等于0，直接返回。否之，返回~a+1
        int c = -33, d = 99;
        int ii = c >> 31;
        int jj = d >> 31;
        System.out.println(ii == 0 ? c : (~c + 1));
        System.out.println(jj == 0 ? d : (~d + 1));
        // 对于任何数，与0异或都会保持不变，与-1即0xFFFFFFFF异或就相当于取反。
        // 因此，a与i异或后再减i（因为i为0或-1，所以减i即是要么加0要么加1）也可以得到绝对值
        System.out.println((c ^ ii) - ii);
        System.out.println((d ^ jj) - jj);

    }
}
