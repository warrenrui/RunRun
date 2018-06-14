package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class testMemLeak {
    public static void main(String[] args) {
        final int a = 4;
        Vector v = new Vector(10);
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Object o = new Object();
            // v.add(o);
            list.add(o);
            o = null;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------");
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
        System.gc();

        System.out.println("-------------------");
        Vector vector = new Vector();
        Object object = new Object();
        vector.add(object);
        System.out.println("before \"object=null\" objcet===" + object);
        object = null;
        System.out.println("after \"object=null\"  object===" + object);
        System.out.println("vector.get(0)===" + vector.get(0));

    }
}
