package designPattern.TemplatePattern;

public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football game end!");
    }

    @Override
    void initialize() {
        System.out.println("Football game initialized!");
    }

    @Override
    void startPlay() {
        System.out.println("Football game start!");
    }

}
