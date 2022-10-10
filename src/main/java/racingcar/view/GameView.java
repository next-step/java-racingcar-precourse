package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameView {
    public void CarNameInputGuideMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void TryInputGuideMsg() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void StartCurrentDistance() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printCurrentDistance(Cars cars) {
        List<Car> carList = cars.getCarList();
        for(Car car : carList){
            System.out.println(car.getCarName() + " : " + printCarDistanceByStick(car));
        }
        System.out.println();
    }

    public String printCarDistanceByStick(Car car){
        StringBuilder builder = new StringBuilder();
        for(int i =0; i < car.getCarDistance(); i++){
            builder.append("-");
        }
        return builder.toString();
    }

    public void printCarWinner(Cars cars){
        if(cars != null)
            System.out.println("최종 우승자 : "+String.join(",",cars.getWinnerName()));
    }

}
