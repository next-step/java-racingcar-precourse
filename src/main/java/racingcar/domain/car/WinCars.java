package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class WinCars {
    List<String> winCarsName;

    public WinCars() {
        winCarsName = new ArrayList<>();
    }

    public void addCar(String carName) {
        winCarsName.add(carName);
    }

    public List<String> getWinCarsName() {
        return winCarsName;
    }

    public String getCarsNameString() {
        String winNames = winCarsName.toString();
        return winNames.substring(1, winNames.length()-1);
    }

}
