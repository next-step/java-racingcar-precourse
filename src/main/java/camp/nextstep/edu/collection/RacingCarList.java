package camp.nextstep.edu.collection;

import camp.nextstep.edu.game.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {

    private final List<RacingCar> carList = new ArrayList<>();

    public RacingCarList(String[] names) {
        for (String name : names) {
            carList.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getCarList() {
        return carList;
    }
}
