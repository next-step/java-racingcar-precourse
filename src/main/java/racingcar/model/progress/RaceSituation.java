package racingcar.model.progress;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.cars.factory.Title;

public class RaceSituation {
    private final List<CarMoveHistory> carMoveHistories;

    private RaceSituation(List<CarMoveHistory> carMoveHistories) {
        this.carMoveHistories = carMoveHistories;
    }

    public static RaceSituation of(List<CarMoveHistory> carMoveHistories) {
        return new RaceSituation(carMoveHistories);
    }

    public RaceScore report(Judge judge) {
        return RaceScore.of(this.getCarMoveScoresList(judge));
    }

    private static CarMoveScores getCarMoveScores(CarMoveHistory carMoveHistory, Judge judge) {
        Title title = carMoveHistory.getTitle();
        MoveScores moveScores = judge.call(carMoveHistory.getMoveHistory());
        return new CarMoveScores(title, moveScores);
    }

    private List<CarMoveScores> getCarMoveScoresList(Judge judge) {
        List<CarMoveScores> carMoveScoresList = new ArrayList<>();
        for (CarMoveHistory carMoveHistory : carMoveHistories) {
            carMoveScoresList.add(RaceSituation.getCarMoveScores(carMoveHistory, judge));
        }
        return carMoveScoresList;
    }
}
