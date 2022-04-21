package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {
    private List<Car> racingCarList = new ArrayList<>();

    public RacingCarGame(String carNameList) {
        this.createCar(carNameList.split(","));
    }

    private void createCar(String[] carNames){
        for(String carName : carNames){
            racingCarList.add(new Car(carName));
        }
    }

    public String getWinnerNames() {
        StringBuilder result = new StringBuilder("최종 우승자: ");
        Collections.sort(racingCarList, (car1, car2) -> car2.getPosition() - car1.getPosition());
        int max = 0;
        for(Car car : racingCarList) {
            if(isWinner(max, car.getPosition())){
                max = car.getPosition();
                result.append(car.getName()).append(",");
                continue;
            }
            break;
        }
        return result.substring(0, result.length()-1);
    }

    private boolean isWinner(int max, int position) {
        return max <= position;
    }
}
