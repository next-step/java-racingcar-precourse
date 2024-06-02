package View;

import Model.Car;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OutputView {
    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표, 기준으로 구분)";
    private static final String QUESTION_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String EXECUTION_MESSAGE = "실행 결과";
    public void printQuestCarName(){
        System.out.println(QUESTION_CAR_NAME);
    }

    public void printQuestRound(){
        System.out.println(QUESTION_ROUND);
    }

    public void printExeResult(){
        System.out.println(EXECUTION_MESSAGE);
    }

    public void printCarDistance(ArrayList<Car> cars){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getDistance(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinner(ArrayList<Car> winners){
        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
