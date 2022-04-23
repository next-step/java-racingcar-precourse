package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RacingResult {
    @NonNull
    @Getter
    private final List<RoundResult> roundResultList;

    public List<RacingCar> getWinners() {
        List<RacingCar> winners = new ArrayList<>();

        if (!roundResultList.isEmpty()) {
            RoundResult roundResult = roundResultList.get(roundResultList.size() - 1);
            winners = getWinners(roundResult);
        }

        return winners;
    }

    private List<RacingCar> getWinners(RoundResult roundResult) {
        List<RacingCar> winners = new ArrayList<>();

        List<RacingCar> sortedRacingCars = roundResult.getRacingCars().getSortedRacingCars();
        int winnerMoveCount = sortedRacingCars.get(0).getMoveCount();

        for (RacingCar car : sortedRacingCars) {
            addWinner(car, winnerMoveCount, winners::add);
        }

        return winners;
    }

    private void addWinner(RacingCar car, int winnerMoveCount, Consumer<RacingCar> callback) {
        if (winnerMoveCount == car.getMoveCount()) {
            callback.accept(car);
        }
    }


}
