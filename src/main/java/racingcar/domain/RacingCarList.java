package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.messenger.MoveNumber;
import racingcar.messenger.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {

    private final List<RacingCar> racingCarList;

    public RacingCarList(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public void racingCarMove() {
        for (RacingCar car : this.racingCarList) {
            int randomNum = Randoms.pickNumberInRange(MoveNumber.MIN.getNumber(), MoveNumber.MAX.getNumber());
            car.movePosition(ValidationUtils.validateGo(randomNum));
        }
    }

    public int racingCarMaxPosition() {
        int maxPosition = 0;
        for (RacingCar car : this.racingCarList) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<RacingCar> racingCarWinner(int maxPosition) {
        List<RacingCar> winnerList = new ArrayList<>();
        for (RacingCar car : this.racingCarList) {
            if (maxPosition == car.getPosition()) {
                winnerList.add(RacingCar.winnerRacingCar(car.getName(), car.getPosition()));
            }
        }
        return winnerList;
    }

    public static RacingCarList of(List<RacingCar> racingCarList) {
        return new RacingCarList(racingCarList);
    }

    public static RacingCarList testInstance(List<RacingCar> racingCarList) {
        return new RacingCarList(racingCarList);
    }

}
