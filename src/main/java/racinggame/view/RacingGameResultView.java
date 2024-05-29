package racinggame.view;

import java.util.List;
import racinggame.domain.Car;

public class RacingGameResultView {

    // Car 객체의 position 을 시각적으로(-을 이용하여) 표현하는 메서드
    public void printCarPositions(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getName() + ":");
            for (int i = 0; i < car.getPosition(); i++){
                System.out.println("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
