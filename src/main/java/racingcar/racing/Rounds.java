package racingcar.racing;

import static racingcar.utils.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import racingcar.car.Cars;
import racingcar.game.InputRoundCount;

public class Rounds {
    private List<Round> rounds;

    private Rounds(final List<Round> rounds) {
        this.rounds = rounds;
    }

    public static Rounds countOf(final InputRoundCount inputRoundCount, final Cars cars) {
        validateInputRoundCount(inputRoundCount);
        validateCars(cars);
        return new Rounds(inputRoundCount.mapTimes(() -> Round.of(cars)));
    }

    public Winners startAll() {
        WinnerCounts winnerCounts = WinnerCounts.init();
        for (Round round : rounds) {
            round.start();
            winnerCounts.countingCars(round.getGoCars());
        }
        return Winners.init(winnerCounts);
    }

    public boolean isFinish() {
        boolean finish = true;
        for (Round round : rounds) {
            finish = finish && round.isFinish();
        }

        return finish;
    }

    public <T> List<T> mapToList(final Function<Round, T> function) {
        List<T> tList = new ArrayList<>();
        for (Round round : rounds) {
            tList.add(function.apply(round));
        }
        return tList;
    }

    public RoundResults cumulativeRoundResults(final Round round) {
        final int index = rounds.indexOf(round);
        final RoundResults roundResults = RoundResults.init();

        for (int i = 0; i <= index; i++) {
            roundResults.addAll(rounds.get(i).getRoundResults());
        }

        return roundResults;
    }

    protected List<Round> getRounds() {
        return rounds;
    }

    private static void validateInputRoundCount(final InputRoundCount inputRoundCount) {
        if(isEmpty(inputRoundCount)) {
            throw new IllegalArgumentException("[ERROR] 사용자 입력 실행 횟수는 null 일 수 없습니다.");
        }
    }

    private static void validateCars(final Cars cars) {
        if (isEmpty(cars)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 null 일 수 없습니다.");
        }
    }
}
