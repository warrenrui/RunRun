package designPattern.observer.jdkUtil;

public class PleasantGoatAndBigBigWolf {
    public static void main(String[] args) {
        WolfBeObservedBySheeps wolf = new WolfBeObservedBySheeps("BigBigWolf");
        SheepObservingWolf pleasantGoat = new SheepObservingWolf("pleasantGoat");
        SheepObservingWolf lazyGoat = new SheepObservingWolf("lazyGoat");
        wolf.addObserver(pleasantGoat);
        wolf.addObserver(lazyGoat);
        wolf.howl("coming");
    }
}
