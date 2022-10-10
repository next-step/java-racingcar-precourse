package racingcar.domain.racing.result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;

public class WinnerResult implements Result {

    public static final String WINNER_PREPEND = "최종 우승자 : ";
    private static final int MAX_MOVE_COUNT = 0;
    private static final int WINNER_BEGINNING = 0;
    private static final int WINNER_END = (-2);
    String winner;
    String moveResult;
    Result result;

    public WinnerResult(Result result) {
        this.result = result;
        this.winner = "";
    }

    @Override
    public String moveResult(List<Car> cars, List<Integer> randoms) {
        moveResult = result.moveResult(cars, randoms);
        return moveResult;
    }

    public String winner(List<Car> cars) {
        List<Integer> maxMoveCount = createMaxMoveCount(cars);
        List<String> winners = createWinners(cars, maxMoveCount.get(MAX_MOVE_COUNT));
        for (String winnerName : winners) {
            winner = String.format("%s%s", winner, winnerName + SEPARATOR);
        }
        winner = WINNER_PREPEND + winner.substring(WINNER_BEGINNING, winner.length() + WINNER_END);
        return winner;
    }

    private List<String> createWinners(List<Car> cars, int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            isWinnerThenAddWinners(maxMoveCount, winners, car);
        }
        return winners;
    }

    private void isWinnerThenAddWinners(int maxMoveCount, List<String> winners, Car car) {
        if (car.isWinner(maxMoveCount)) {
            winners.add(car.carName());
        }
    }

    private List<Integer> createMaxMoveCount(List<Car> cars) {
        List<Integer> maxMoveCount = new ArrayList<>();
        for (Car car : cars) {
            maxMoveCount.add(car.moveCount());
        }
        maxMoveCount.sort(Comparator.reverseOrder());
        return maxMoveCount;
    }

    @Override
    public String toString() {
        return moveResult + winner;
    }
}
