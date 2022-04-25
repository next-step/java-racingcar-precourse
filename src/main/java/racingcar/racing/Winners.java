package racingcar.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Winners {
    private List<Winner> winners;

    private Winners(final List<Winner> winners) {
        this.winners = winners;
    }

    public static Winners init(final WinnerCounts winnerCounts) {
        validateWinnerCounts(winnerCounts);
        return new Winners(getWinners(winnerCounts));
    }

    public <T> List<T> mapTo(final Function<Winner, T> function) {
        List<T> tList = new ArrayList<>();

        for (Winner winner : winners) {
            tList.add(function.apply(winner));
        }

        return tList;
    }

    private static void validateWinnerCounts(final WinnerCounts winnerCounts) {
        if (!winnerCounts.hasWinners()) {
            throw new IllegalArgumentException("[ERROR] 우승자가 없습니다.");
        }
    }

    private static List<Winner> getWinners(final WinnerCounts winnerCounts) {
        return winnerCounts.maxCountCars()
                        .mapToList(Winner::new);
    }
}
