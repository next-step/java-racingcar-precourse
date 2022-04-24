package racingcar.domain;

import java.util.List;
import java.util.ArrayList;
import racingcar.common.ValidationCheck;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String[] racingCarsName) {
        this.racingCars = setRacingCars(racingCarsName);
    }

    private List<RacingCar> setRacingCars(String[] racingCarsName) {
        List<RacingCar> racingCars = new ArrayList<RacingCar>();
        for (int index = 0; index < racingCarsName.length; index++) {
            racingCars.add(new RacingCar(racingCarsName[index]));
        }
        return  racingCars;
    }

    public String getNameByIndex(int index) {
        RacingCar racingCar = racingCars.get(index - 1);
        return racingCar.getName();
    }

    public int getGoCountByIndex(int index) {
        RacingCar racingCar = racingCars.get(index - 1);
        return racingCar.getGoCount();
    }

    public RacingCar getRacingCarByIndex(int index) {
        RacingCar racingCar = racingCars.get(index - 1);
        return racingCar;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }


}
