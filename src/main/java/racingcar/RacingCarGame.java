package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {
    private static final int MIN = 0;
    private static final int MAX = 9;
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

    public void racing(String tryCount) {
        this.validateTryCount(tryCount);
        for (int i = 0; i < Integer.parseInt(tryCount); i++) {
            for(Car car : racingCarList) {
                car.move(Randoms.pickNumberInRange(MIN, MAX));
            }
            this.print();
        }
    }

    private void validateTryCount(String tryCount) {
        int result = 0;
        try {
            result = Integer.parseInt(tryCount);
        }catch (Exception e){
            throw new NumberFormatException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        if(result <= 0) throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야합니다.");
    }

    private void print() {
        StringBuilder result = new StringBuilder();
        for(Car car : racingCarList) {
            result.append(car.getName()).append(": ");
            if(car.getPosition() > MIN){
                result.append(this.stepString(car.getPosition()));
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    private String stepString(int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
