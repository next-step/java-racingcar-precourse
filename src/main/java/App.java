import domain.CarNames;
import domain.Game;
import view.InputView;
import view.PrintView;
import domain.TryCount;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        CarNames names = inputView.carNames();
        TryCount tryCount = inputView.tryCount();

        Game game = new Game(names);

        game.move(tryCount);

        PrintView printView = new PrintView(game);

        printView.printMoveHistories();
        printView.printWinners();
    }
}
