package designPattern.proxy.grapic;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(n |= n >>> 1);

        // 使用匿名类重写父类的某方法
        Map<String, String> map = new LinkedHashMap<String, String>() {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
                return super.removeEldestEntry(eldest);
            }
        };

        // 无符号右移一位
        System.out.println(11 >>> 1);
        System.out.println(11 >> 1);
        System.out.println(10 >> 1);

        JFrame frame = new JFrame("Proxy test client");
        JLabel label = new JLabel("Loading web page ......");
        frame.getContentPane().add(label);
        PageProxy pageProxy = new PageProxy();
        frame.getContentPane().add(pageProxy);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        // frame.pack();
        frame.setVisible(true);

        pageProxy.label.setText("aaa");
    }
}