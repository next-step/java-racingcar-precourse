package racingcar;

import racingcar.model.Players;
import racingcar.model.RacingGame;
import racingcar.model.primitive.GameCount;
import racingcar.strategy.RacingCarGameStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    private static boolean keepGoing = false;
    private static Players players;
    private static GameCount gameCount;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        initPlayersWithValidation();
        initGameCountWithValidation();

        RacingGame racingGame = new RacingGame(players, gameCount, new RacingCarGameStrategy());
        racingGame.playGames();
        OutputView.resultPrintOut(racingGame.totalScoreBoards(), racingGame.winnerList());
    }

    private static void initGameCountWithValidation() {
        initLoopCondition();
        while (!keepGoing) {
            gameCount = new GameCount(initGameCount());
        }
    }

    private static int initGameCount() {
        try {
            keepGoing = true;
            return Integer.parseInt(InputView.askQuestion("2"));
        } catch (NumberFormatException nbe) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            keepGoing = false;
        }
        return 0;
    }

    private static void initPlayersWithValidation() {
        initLoopCondition();
        while (!keepGoing) {
            players = initPlayers();
        }
    }

    private static void initLoopCondition() {
        keepGoing = false;
    }

    private static Players initPlayers() {
        try {
            keepGoing = true;
            return new Players(InputView.askQuestion("1"));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR]: 사용자 이름은 5자 이하여야 합니다.");
            keepGoing = false;
        }
        return null;
    }
}
