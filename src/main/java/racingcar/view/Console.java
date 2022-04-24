package racingcar.view;

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
        cars.getCars().forEach(car -> System.out.println(car.getName() + ":" + car.getSteps()));
        System.out.println();
    }
}
