package designPattern.proxy.grapic;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageProxy extends JPanel {
    public PageProxy() {
        label = new JLabel("Loading web page !!!!!");
        this.add(label);
    }

    public JLabel label;
}