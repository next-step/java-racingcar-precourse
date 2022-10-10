package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private List<RacingCar> cars;
    private List<RacingCar> winRacingCar;
    List<Integer> cntList = new ArrayList<Integer>();

    public RacingResult(List<RacingCar> cars) {
        this.cars = cars;
        this.winRacingCar = new ArrayList<>();
    }

    public void getMaxMoveCar() {

        for(int i=0; i<cars.size(); i++) {
            cntList.add(cars.get(i).moveCnt());
        }

        int maxMove = Collections.max(cntList);
        winRacingCar = cars.stream().filter(car -> car.moveCnt() == maxMove).collect(Collectors.toList());
    }

    public List<RacingCar> getWinRacingCar() {
        return winRacingCar;
    }
}
