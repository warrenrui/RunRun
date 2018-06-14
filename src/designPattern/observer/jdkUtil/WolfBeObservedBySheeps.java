package designPattern.observer.jdkUtil;

import java.util.Observable;

public class WolfBeObservedBySheeps extends Observable {
    private String name;

    WolfBeObservedBySheeps(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void howl(String state) {
        System.out.println(this.getName() + " howling!");
        this.setChanged();
        this.notifyObservers(state);
    }
}
