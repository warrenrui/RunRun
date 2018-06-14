package designPattern.future;

public class FutureMain {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        FutureClient fc = new FutureClient();
        Data data = fc.request("请求参数");
        System.out.println("请求发送成功");
        System.out.println("做其他事情");
        String result = data.getRequest();
        System.out.println(result);
    }

}
