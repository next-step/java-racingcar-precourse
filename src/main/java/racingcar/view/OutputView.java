package racingcar.view;

import racingcar.model.Car;
import racingcar.model.RacingCar;

public class OutputView {
    public static void printMessage(String msg){
        System.out.println(msg);
    }
    public static void printRace(Car[] carsForRacing){
        for(Car car: carsForRacing){
            System.out.print(car.getName()+" : ");
            printBar(car.getPosition());
        }
        System.out.println();
    }

    public static void printBar(int position){
        for(int j=0;j<position;j++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(String[] winners){
        System.out.print("최종 우승자: "+String.join(", ", winners));
    }
}
