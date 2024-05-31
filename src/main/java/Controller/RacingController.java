package Controller;

import DTO.Car;
import Service.RacingService;
import Util.Util;
import View.Print;
import java.util.List;

public class RacingController {

    Print print = new Print();
    Util util = new Util();

    RacingService racing = new RacingService();

    public List<Car> playRacing(List<Car> cars, int N) {
        print.print("\n 실행결과");
        while (N-- > 0) {
            for (Car car : cars) {
                racing.updateNum(util.generateRandomNumber(), car);
                print.printSteps(car.getName(), car.getNum());
            }
            System.out.println();
        }
        return cars;
    }
}
