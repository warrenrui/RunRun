package reflection;

import java.lang.reflect.Method;

public class InvokeTest {
    public String add(int param1, int param2) {
        return param1 + " + " + param2 + " = " + (param1 + param2);
    }

    public String sayHi(String message) {
        return "hi " + message;
    }

    public String objectToString(Method method) {
        return method.toString();
    }

    public static void main(String[] args) throws Exception {
        // 常规执行方式
        InvokeTest invokeTest1 = new InvokeTest();
        System.out.println(invokeTest1.add(1, 2));
        System.out.println(invokeTest1.sayHi("jack"));

        // 第一步：获取Class对象，方式：1、使用Class类的静态方法；2、使用类的.class语法；3、使用对象的getClass()方法
        Class<?> clazz;
        clazz = Class.forName("reflection.InvokeTest");
        clazz = InvokeTest.class;
        InvokeTest invokeTest = new InvokeTest();
        clazz = invokeTest.getClass();

        // 直接到达第三步
        Method addMethod0 = Class.forName("reflection.InvokeTest").getDeclaredMethod("add", new Class[]{int.class, int.class});
        String result = (String) addMethod0.invoke(InvokeTest.class.newInstance(), new Object[]{1, 2});
        System.out.println("快速调用   " + result);

        // 第二步：生成新的对象
        Object invokeTest2 = clazz.newInstance();
        System.out.println(invokeTest2 instanceof InvokeTest);

        // 第三步：通过反射调用方法，首先获得与该方法对应的Method对象
        // 第一个参数是要调用的方法名，第二个参数是该方法所需要的参数的Class对象数组
        // Method addMethod = invokeTest2.getClass().getMethod("add", new
        // Class[] { int.class, int.class });
        Method addMethod = invokeTest2.getClass().getMethod("add", new Class[]{int.class, int.class});
        Method sayHiMethod = invokeTest2.getClass().getMethod("sayHi", new Class[]{String.class});
        Method objectToStringMethod = invokeTest2.getClass().getMethod("objectToString", new Class[]{Method.class});
        // 单一参数的也可以这样，多参数的需要用 new Class[] {}
        sayHiMethod = invokeTest2.getClass().getMethod("sayHi", String.class);
        objectToStringMethod = invokeTest2.getClass().getMethod("objectToString", Method.class);

        // 第四步：调用方法
        String addResult = (String) addMethod.invoke(invokeTest2, new Object[]{3, 2});
        System.out.println(addResult);
        String sayHiResult = (String) sayHiMethod.invoke(invokeTest2, "rose");
        System.out.println(sayHiResult);
        String objectToStringResult = (String) objectToStringMethod.invoke(invokeTest2, objectToStringMethod);
        System.out.println(objectToStringResult);
    }
}
