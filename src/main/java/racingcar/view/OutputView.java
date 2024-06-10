package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void printHead(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printScore(List<Car> cars){
        for(Car car : cars) {
            printCarScore(car);
        }
        System.out.println();
    }

    public static void printCarScore(Car car){
        System.out.print(car.getName()+" : ");
        printCarPosition(car);
        System.out.println();
    }

    public static void printCarPosition(Car car){
        for(int i=0; i<car.getPosition(); i++){
            System.out.print("-");
        }
    }
}
