package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingGameResult {
    private List<RacingCar> winners;
    private int maxDistance;

    public RacingGameResult(List<RacingCar> winners, int maxDistance) {
        this.winners = winners;
        this.maxDistance = maxDistance;
    }

    public List<RacingCar> winners() {
        return winners;
    }

    public int maxDistance() {
        return maxDistance;
    }

    public void changeMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void clear() {
        this.winners.clear();
    }

    public void add(RacingCar car) {
        this.winners.add(car);
    }
}
