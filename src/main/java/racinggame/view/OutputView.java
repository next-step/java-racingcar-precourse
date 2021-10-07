package racinggame.view;

import racinggame.Car;

public class OutputView {
    public static void displayCar(Car car){
        System.out.print(car.getCarNm() + " : ");
        for(int i=0;i<car.getDistance();i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
