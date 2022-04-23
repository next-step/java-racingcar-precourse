package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class RacingCars {

    @NonNull
    private final List<RacingCar> racingCarList;

    public List<RacingCar> getSortedRacingCars() {
        Collections.sort(racingCarList);
        return Collections.unmodifiableList(racingCarList);
    }

    public static RacingCars newInstance(RacingCars cars) {
        List<RacingCar> newRacingCarList = new ArrayList<>();

        for (RacingCar car : cars.getSortedRacingCars()) {
            newRacingCarList.add(RacingCar.newInstance(car));
        }

        return new RacingCars(newRacingCarList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (RacingCar car : racingCarList) {
            sb.append(car.toString()).append("\n");
        }

        return sb.toString();
    }
}
