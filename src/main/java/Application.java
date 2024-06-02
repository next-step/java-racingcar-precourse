import Controller.Game;
import View.InputView;
import View.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Game game = new Game(inputView, resultView);
        game.play();
    }
}