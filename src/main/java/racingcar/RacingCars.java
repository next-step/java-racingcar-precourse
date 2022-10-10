package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCarList;

    public RacingCars(String[] carNamesArray) {
        racingCarList = makeRacingCarList(carNamesArray);
    }

    private List<RacingCar> makeRacingCarList(String[] carNamesArray) {
        List<RacingCar> result = new ArrayList<>();
        for(String carName : carNamesArray) result.add(new RacingCar(carName, 0));
        return result;
    }

    public int race(){
        int maxPostiion = 0;
        for(RacingCar racingCar : racingCarList){
            racingCar.checkCarAction(new RandomAction().getRacingCarAction());
            maxPostiion = Math.max(racingCar.getRacingCarPosition(), maxPostiion);
        }
        return maxPostiion;
    }

    public List<RacingCar> getWinnerCar(int maxPosition){
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getRacingCarPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
