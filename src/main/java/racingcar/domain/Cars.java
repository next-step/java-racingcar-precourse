package racingcar.domain;

import racingcar.view.PlayResult;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public CarStatus play() {
        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            isStateComplete(cars.get(i).run(getRandomNum()));
            PlayResult.getProcessPrint(car);
        }
        System.out.println("");
        return CarStatus.RUN_END;
    }

    public int getRandomNum() {
        return pickNumberInRange(0, 9);
    }

    public int getMaxProcess() {
        int maxProgress = 0;
        for(Car car : cars) maxProgress = Math.max(maxProgress, car.getProgress().length());
        return maxProgress;
    }

    public List<String> setWinnerCars(int maxProcess) {
        List<String> result = new ArrayList<>();
        for(Car car : cars) {
            car.updateWinner(maxProcess);
            result.add(getWinnerText(car));
        }
        return result;
    }

    public String getWinnerText(Car car) {
        if(car.getWinner()) return car.getName();
        return "";
    }

    public boolean isStateComplete(CarStatus carStatus) {
        if(carStatus == CarStatus.GO || carStatus == CarStatus.STOP) return true;
        throw new IllegalStateException("자동차 상태 리턴 값이 오류입니다.");
    }
}
