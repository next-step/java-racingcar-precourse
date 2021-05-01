import domain.CarNames;
import domain.Game;
import view.InputView;
import view.PrintView;

public class App {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        String names = inputView.carNames();
        int tryCount = inputView.tryCount();

        Game game = new Game(new CarNames(names));

        game.move(tryCount);

        PrintView printView = new PrintView(game);

        printView.printMoveHistories();
        printView.printWinners();
    }
}
