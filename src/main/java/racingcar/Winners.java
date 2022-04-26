package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<RacingCar> winnerRacingCars = new ArrayList<>();

    public Winners(List<RacingCar> racingCars) {
        initWinner(racingCars);
    }

    private void initWinner(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            registerWinnerCar(racingCar);
        }
    }

    private void registerWinnerCar(RacingCar racingCar) {
        int currentLocation = racingCar.getCurrentLocation();

        if (winnerRacingCars.size() == 0) {
            winnerRacingCars.add(racingCar);
            return;
        }

        if (winnerRacingCars.get(0).getCurrentLocation() == currentLocation) {
            winnerRacingCars.add(racingCar);
        }

        if (winnerRacingCars.get(0).getCurrentLocation() < currentLocation) {
            winnerRacingCars.clear();
            winnerRacingCars.add(racingCar);
        }
    }

    public List<RacingCarName> getWinnerNames() {
        List<RacingCarName> winnerNames = new ArrayList<>();
        for (RacingCar winnerRacingCar : winnerRacingCars) {
            winnerNames.add(winnerRacingCar.getRacingCarName());
        }

        return winnerNames;
    }
}
