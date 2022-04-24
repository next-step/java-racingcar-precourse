package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Console {
    public static void printEnterCarName(){
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분");
    }

    public static void printEnterTurns(){
        System.out.println("시도할 횟수");
    }

    public static void printResult(){
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars){
        cars.getCars().forEach(car -> System.out.println(car.getName() + " : " + getSteps(car.getSteps())));
        System.out.println();
    }

    private static String getSteps(Integer steps){
        StringBuilder ret = new StringBuilder("");
        for(int i=0; i<steps; i++){
            ret.append("-");
        }
        return ret.toString();
    }

    public static void printWinner(Cars cars){
        List<Car> winners = cars.getWinners();
        List<String> winnerNames = new ArrayList<>();
        for(Car car : winners){
            winnerNames.add(car.getName());
        }
        System.out.println("최종 우승자: " + String.join(",",winnerNames));
    }
}
