package racinggame.domain;

import racinggame.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private GameView gameView;
    private RacingGame racingGame;
    private List<Car> cars;
    private int tryNo = 0;

    public void run() {
        // 레이싱 게임 생성
        gameView = new GameView();
        racingGame = new RacingGame(
                RacingGame.initCars(gameView.inputCars()),
                gameView.inputTryNo()
        );

        // 레이싱 반복
        while(racingGame.racing()) {
            racingGame.race();
            gameView.printCars(racingGame.getCars());
        }

        // 우승자 출력
        int maxPosition = getMaxPosition(racingGame.getCars());
        gameView.printWinners(findWinnersNames(racingGame.getCars(), maxPosition));
    }

    private int getMaxPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars)
            max = car.getPosition().getMaxPosition(max);
        return max;
    }

    private String findWinnersNames(List<Car> cars, int max) {
        List<String> winners = new ArrayList<>();
        Position maxPosition = new Position(max);
        for (Car car : cars) {
            if (car.getPosition().equals(maxPosition))
                winners.add(car.getName());
        }
        return String.join(",", winners);
    }
}
