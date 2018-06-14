package others;

public class Fibonacci {
    public static void main(String[] args) {
        long sum = fibonacci(3);
        System.out.println(sum);
    }

    public static long fibonacci(long count) {
        if (count < 1) {
            return 1;
        } else {
            return fibonacci(count - 1) + fibonacci(count - 2);
        }
    }
}
