package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> RacingCars;

    public Cars(String[] InputCars) {
        this.RacingCars = mapCars(InputCars);

    }

    public List<Car> getRacingCars() {
        return RacingCars;
    }

    public Car getRacingCar(int i) {
        return RacingCars.get(i);
    }


    private List<Car> mapCars(String[] InputCarNames) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < InputCarNames.length; i++) {
            cars.add(new Car(InputCarNames[i]));
        }
        return cars;
    }

    public void run() {
        for (int carNum = 0; carNum < RacingCars.size(); carNum++) {
            GoForwadIfSatisfied(carNum);
        }

    }

    private void GoForwadIfSatisfied(int carNum) {
        if (isForward(carNum)) {
            getRacingCar(carNum).goForward();
        }
    }

    private boolean isForward(int carNum) {
        return getRacingCar(carNum).run(Randoms.pickNumberInRange(0, 9)) == CarCondition.Forword;
    }

    public String getRacingCarName(int carNum) {
        return this.getRacingCar(carNum).getCarName();
    }

    public int getRacingCarPosition(int carNum) {
        return this.getRacingCar(carNum).getPosition();
    }

    public int getCarCount() {
        return this.RacingCars.size();
    }
}
