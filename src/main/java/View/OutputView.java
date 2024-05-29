package View;

import Model.Car;
import java.util.ArrayList;

public class OutputView {
    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표, 기준으로 구분)";
    private static final String QUESTION_ROUND = "시도할 회수는 몇 회 인가요?";

    public void printQuestCarName(){
        System.out.println(QUESTION_CAR_NAME);
    }

    public void printQuestRound(){
        System.out.println(QUESTION_ROUND);
    }

    public void printCarDistance(ArrayList<Car> cars){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getDistance(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
