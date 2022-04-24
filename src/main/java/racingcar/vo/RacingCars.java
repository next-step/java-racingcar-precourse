package racingcar.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import racingcar.constant.RacingCarNameLength;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private final List<RacingCar> racingCarList;

    public RacingCars(List<String> carNameList) {
        for (String carName : carNameList) {
            validateCarNameLength(carName);
        }
        validateCarNameDuplication(carNameList);

        this.racingCarList = new ArrayList<>();
        convertToRacingCar(carNameList);
    }

    private void validateCarNameLength(String carName) {
        int carNameLength = carName.length();
        if (carNameLength < RacingCarNameLength.MIN || carNameLength > RacingCarNameLength.MAX) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LIMIT);
        }
    }

    private void validateCarNameDuplication(List<String> carNameList) {
        int inputCarNameSize = carNameList.size();
        int deleteDuplicationCarNameSize = new HashSet<>(carNameList).size();
        if (inputCarNameSize > deleteDuplicationCarNameSize) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATION);
        }
    }

    private void convertToRacingCar(List<String> carNameList) {
        for (String carName : carNameList) {
            this.racingCarList.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public List<RacingCar> getGameWinnerList() {
        List<RacingCar> copyRacingCarList = new ArrayList<>(racingCarList);
        copyRacingCarList.sort((car1, car2) -> Integer.compare(car2.getLocation(), car1.getLocation()));
        List<RacingCar> winnerList = new ArrayList<>();
        calcWinnerList(winnerList, copyRacingCarList);
        return winnerList;
    }

    private void calcWinnerList(List<RacingCar> winnerList, List<RacingCar> copyRacingCarList) {
        int pervRacingCarLocation = 0;
        for (RacingCar racingCar : copyRacingCarList) {
            if (pervRacingCarLocation > racingCar.getLocation()) {
                break;
            }
            pervRacingCarLocation = racingCar.getLocation();
            winnerList.add(racingCar);
        }
    }
}
