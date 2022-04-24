package racingcar;

import racingcar.model.Game;
import racingcar.ui.GameInput;

public class Application {
    public static void main(String[] args) {
        String nameInput = GameInput.getCarNames();
        int roundInput = GameInput.getTotalRound();
        System.out.println();
        System.out.println("실행 결과");
        Game game = new Game(nameInput, roundInput);
        for (int i = 1; i <= game.getTotalRound(); i++) {
            game.run();
        }
        System.out.printf("최종 우승자: %s", game.getWinnerName());
    }
}
