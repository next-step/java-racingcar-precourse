package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String INVALID_TRY_COUNT = "시도 횟수는 숫자여야 한다.";
    private final Cars cars = new Cars();
    private final GameResult gameResult = new GameResult();

    public Game(String playerList) throws IllegalArgumentException{
        String[] players = playerList.split(",");
        for (String player : players) {
            cars.addCar(new Car(player));
        }
    }

    public Cars playerList() {
        return cars;
    }

    public GameResult run(String runCount) throws IllegalArgumentException{
        int convertRunCount = ConvertIntegerRunCount(runCount);
        for (int i=0; i < convertRunCount; i++) {
            executeGame();
        }
        return gameResult;
    }

    private void executeGame() {
        List<Car> carList = cars.carList();
        List<Integer> gameStatus = new ArrayList<>();
        for (Car car : carList) {
            car.moveOrStop(new RandomNumberStrategy());
            gameStatus.add(car.getPosition());
        }
        gameResult.addStatus(new GameStatus(gameStatus));
    }

    public GameResult gameResult() {
        return gameResult;
    }

    public String getWinner() {
        int finalMaxPosition = gameResult.getGameResult().get(gameResult.totalExecuteCount()-1).getMaxPosition();
        List<String> result = new ArrayList<>();
        for (Car car : cars.carList()) {
            findWinner(finalMaxPosition, result, car);
        }
        return generateWinnerName(result);
    }

    private void findWinner(int finalMaxPosition, List<String> result, Car car) {
        if (car.getPosition() == finalMaxPosition) {
            result.add(car.getCarName());
        }
    }

    private String generateWinnerName(List<String> result) {
        return String.join(",", result);
    }

    private int ConvertIntegerRunCount(String runCount) {
        int result = 0;
        try {
            result = Integer.parseInt(runCount);;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }

        return result;
    }
}
