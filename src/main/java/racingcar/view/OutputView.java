package racingcar.view;

import racingcar.model.domain.Car;

public class OutputView {
    public static void printWinners(String winners){
        System.out.println("최종 우승자: "+winners);
    }

    public static void printCarScore(Car car) {
        System.out.printf("%s : %s \n", car.getName(), car.getDistanceStr());
    }

    public static void printErrorMessage(String message){ System.out.printf("[ERROR] %s \n",message); }
}
