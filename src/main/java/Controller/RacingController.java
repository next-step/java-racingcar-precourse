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

//    레이싱을 수행한다.
//    랜덤닶을 받아 4이상이면 자동차가 한 칸 나아간다.
//    레이싱을 수행한 List<Car>를 반환한다.
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
