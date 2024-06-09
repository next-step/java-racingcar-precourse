import java.util.Scanner;

public class GameController {
    private final GameView gameView;
    private final Scanner scanner;

    public GameController() {
        this.gameView = new GameView();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        String[] carNames = getCarNames();
    }

    private String[] getCarNames() {
        while (true) {
            gameView.requestCarNamesInput();
            String input = scanner.nextLine();
            String[] carNames = input.split(",");
          
        }
    }


}
