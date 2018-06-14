package designPattern.observer.jdkUtil;

import java.util.Observable;
import java.util.Observer;

public class SheepObservingWolf implements Observer {
    private String state = "playing";
    private String name;

    SheepObservingWolf(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((WolfBeObservedBySheeps) o).getName() + " " + arg + " " + this.getName() + " be careful");
        this.setState("be careful");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
