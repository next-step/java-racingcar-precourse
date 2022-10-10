package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final List<RacingCar> racingCarList;

    public RacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public void raceAll() {
        for (RacingCar car : racingCarList) {
            car.race(new MoveNumber());
        }
    }

    public Winners report() {
        Location maxLocation = findMaxLocation();
        List<RacingCarName> winnerList = getWinnerList(maxLocation);
        return new Winners(winnerList);
    }

    private Location findMaxLocation() {
        Location maxLocation = new Location(Integer.MIN_VALUE);
        for (RacingCar car : racingCarList) {
            int carLocationValue = car.getLocation().getLocationValue();
            int maxLocationValue = maxLocation.getLocationValue();
            maxLocation = new Location(Math.max(carLocationValue, maxLocationValue));
        }
        return maxLocation;
    }

    private List<RacingCarName> getWinnerList(Location maxLocation) {
        List<RacingCarName> winnerList = new ArrayList<>();
        for (RacingCar car : racingCarList) {
            addWinnerList(maxLocation, winnerList, car);
        }
        return winnerList;
    }

    private void addWinnerList(Location maxLocation, List<RacingCarName> winnerList, RacingCar car) {
        if (car.getLocation().equals(maxLocation)) {
            winnerList.add(car.getRacingCarName());
        }
    }

    public List<RacingCar> getRacingCarList() {
        List<RacingCar> copyList = new ArrayList<>();
        for (RacingCar car : racingCarList) {
            copyList.add(RacingCar.copy(car));
        }
        return copyList;
    }
}
