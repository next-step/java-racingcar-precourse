package racinggame.service;

import java.util.ArrayList;
import java.util.List;
import racinggame.domain.Car;

public class RacingGameService {
    private List<Car> cars = new ArrayList<>();

    // 입력받은 자동차 이름으로 Car 객체 생성 후 cars 리스트에 삽입
    public void initCar(String carNames){
        for (String carName : carNames.split(",")) {
            cars.add(new Car(carName.trim()));
        }
    }
    //
    public void race(int numOfAttempts){
        for (int i = 0; i < numOfAttempts; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    // 가장 멀리 간 Car 객체의(position 이 높은 Car 객체의) position 을 winnerPosition 에 저장 후
    // winnerPosition 과 같은 position 인 Car 객체를 winners 리스트에 담는 메서드
    public List<Car> getWinners(){
        int winnerPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > winnerPosition){
                winnerPosition = car.getPosition();
            }
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition){
                winners.add(car);
            }
        }
        return winners;
    }
}
