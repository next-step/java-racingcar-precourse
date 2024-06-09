import java.util.Scanner;

public class GameController {
    private Race race;
    private final GameView gameView;
    private final Scanner scanner;

    public GameController() {
        this.race = null;
        this.gameView = new GameView();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        String[] carNames = getCarNames();
        int attemptCount = getAttemptCount();
        race = new Race(carNames);
        race.run(attemptCount);
    }

    private String[] getCarNames() {
        while (true) {
            gameView.requestCarNamesInput();
            String input = scanner.nextLine();
            String[] carNames = input.split(",");
            if (isValidInput(carNames)) {
                return carNames;
            } else {
                gameView.displayErrorMessage("유효하지 않은 입력입니다. 자동차 이름은 5자 이하이어야 합니다.");
            }
        }
    }

    private int getAttemptCount() {
        while (true) {
            gameView.requestAttemptCountInput();
            String input = scanner.nextLine();
            try {
                int attemptCount = Integer.parseInt(input);
                if (attemptCount > 0) {
                    return attemptCount;
                } else {
                    gameView.displayErrorMessage("유효하지 않은 입력입니다. 회수는 1 이상이어야 합니다.");
                }
            } catch (NumberFormatException e) {
                gameView.displayErrorMessage("유효하지 않은 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }



    private boolean isValidInput(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
