package racingcar.model.progress;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RaceScore {
    private final List<CarMoveScores> carMoveScoresList;

    private RaceScore(List<CarMoveScores> carMoveScoresList) {
        this.carMoveScoresList = carMoveScoresList;
    }

    public static RaceScore of(List<CarMoveScores> carMoveScoresList) {
        return new RaceScore(carMoveScoresList);
    }

    public List<CarMoveScores> get() {
        List<CarMoveScores> clones = new ArrayList<>();
        for (CarMoveScores carMoveScores : carMoveScoresList) {
            clones.add(new CarMoveScores(carMoveScores.getTitle(), carMoveScores.getMoveScores()));
        }
        return clones;
    }

    public RaceScore getLeads() {
        MoveScore maxScore = RaceScore.getMaxCarMoveScore(this.get());
        List<CarMoveScores> leads = RaceScore.getCarMoveScoresListSameScore(this.get(), maxScore);
        return RaceScore.of(leads);
    }

    private static List<CarMoveScores> getCarMoveScoresListSameScore(List<CarMoveScores> carMoveScoresList,
            MoveScore targetScore) {
        List<CarMoveScores> leadsWithNull = RaceScore.getCarMoveScoresListWithNullIfDifferentScore(carMoveScoresList,
                targetScore);
        leadsWithNull.removeAll(Collections.singleton(null));
        return leadsWithNull;
    }

    private static List<CarMoveScores> getCarMoveScoresListWithNullIfDifferentScore(
            List<CarMoveScores> carMoveScoresList, MoveScore targetScore) {
        List<CarMoveScores> leadsWithNull = new ArrayList<>();
        for (CarMoveScores carMoveScores : carMoveScoresList) {
            leadsWithNull.add(RaceScore.getCarMoveScoresIfSameScore(carMoveScores, targetScore));
        }
        return leadsWithNull;
    }

    private static CarMoveScores getCarMoveScoresIfSameScore(CarMoveScores carMoveScores, MoveScore targetScore) {
        if (RaceScore.isCarMoveScoresSameScore(carMoveScores, targetScore)) {
            return carMoveScores;
        }
        return null;
    }

    private static boolean isCarMoveScoresSameScore(CarMoveScores carMoveScores, MoveScore targetScore) {
        return carMoveScores.getMoveScores().get().equals(targetScore);
    }

    private static MoveScore getMaxCarMoveScore(List<CarMoveScores> carMoveScoresList) {
        CarMoveScores maxCarMoveScores = Collections.max(carMoveScoresList,
                Comparator.comparing((CarMoveScores s) -> s.getMoveScores().get()));
        return maxCarMoveScores.getMoveScores().get();
    }
}
