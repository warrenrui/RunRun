package reflection;

import java.lang.reflect.Method;

public class TestReflection {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();
        methods = String.class.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
