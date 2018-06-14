package designPattern.TemplatePattern;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Football();
        game.play();
        Game game2 = new Basketball();
        game2.play();
    }
}
