package racingcar.models;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Racing {
    private final Car[] cars;
    private GameResultRepository results;
    private final GameCount gameCount;

    public Racing(RacingVO vo) {
        this.cars = vo.getCars();
        this.gameCount = vo.getGameCount();
    }

    public GameResultRepository getResults() {
        return this.results;
    }

    public Car[] removeNullFromArray(Car[] array) {
        List<Car> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList.removeIf(Objects::isNull);
        return arrayList.toArray(new Car[arrayList.size()]);
    }

    public int getMaxScore() {
        return this.gameCount.getCount();
    }

    public int getMaxWinnerLength() {
        return this.cars.length;
    }

    public Car[] getWinners(RacingScore scores) {
        Car[][] memo = new Car[this.getMaxScore() + 1][this.getMaxWinnerLength()];
        int largestScore = 0;
        for (int i = 0; i < this.cars.length; i++) {
            Car car = this.cars[i];
            int score = scores.getScoreOf(car);
            memo[score][i] = car;
            largestScore = Integer.max(score, largestScore);
        }
        Car[] result = memo[largestScore];
        return this.removeNullFromArray(result);
    }

    public boolean calculateForwardOrNot() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber > 3;
    }

    public GameResult runSingleGame() {
        GameResult result = new GameResult(this.cars);
        for (Car car : this.cars) {
            result.addResult(car, this.calculateForwardOrNot());
        }
        return result;
    }

    public RacingScore getScores() {
        return this.getResults().getScores();
    }

    public void run() {
        int gameCountNum = this.gameCount.getCount();
        GameResult[] results = new GameResult[gameCountNum];
        for (int i = 0; i < gameCountNum; i++) {
            results[i] = this.runSingleGame();
        }
        this.results = new GameResultRepository(results);
    }
}
