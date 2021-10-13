package racinggame.domain;

import java.util.List;

public class GameResult {
    private RacingCars racingCars;

    public GameResult(TryCount tryCount, RacingCars racingCars) {
        gameResult(tryCount, racingCars);
        this.racingCars = racingCars;
    }

    private void gameResult(final TryCount tryCount, final RacingCars racingCars) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            movingRacingCar(racingCars.getRacingCars());
            printResultWithRacingCarName(racingCars.getRacingCars());
        }
    }

    private void movingRacingCar(final List<RacingCar> racingCarList) {
        racingCarList.forEach(racingCar -> racingCar.isMovingForward());
    }

    private void printResultWithRacingCarName(final List<RacingCar> racingCarList) {
        racingCarList.forEach(System.out::println);
        System.out.println();   /* Console 출력 가독성 위함 */
    }

    @Override
    public String toString() {
        return new RacingWinners(racingCars.getWinners()).toString();
    }
}
