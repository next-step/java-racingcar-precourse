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

    // 우승자를 출력하는 메서드
    public void printWinners(List<Car> winners){
        System.out.println("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++){
            System.out.println(winners.get(i).getName());
            // 아직 뒤에 우승자를 더 출력해야 한다면 , 붙임
            if (i < winners.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
