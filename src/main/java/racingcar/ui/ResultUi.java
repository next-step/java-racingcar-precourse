package racingcar.ui;

import java.util.List;
import java.util.StringJoiner;
import racingcar.car.Car;
import racingcar.car.CarName;
import racingcar.car.manager.Cars;
import racingcar.racing.WinnerCars;

public class ResultUi {

    private final static String MOVE = "-";

    public static void resultStart() {
        System.out.println("실행 결과");
    }

    public static void printCar(Car car) {
        Integer location = car.location().getLocation();
        CarName carName = car.carName();
        System.out.print(carName.name() + " : ");
        for (int i = 0 ; i < location; ++i) {
            System.out.print(MOVE);
        }
    }

    public static void printCars(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            printCar(car);
            System.out.println();
        }
    }

    public static void winnerUi(WinnerCars winnerCars) {
        System.out.print("최종 우승자: ");
        List<CarName> carNames = winnerCars.carNames().getCarNames();
        StringBuilder builder = new StringBuilder();
        for (CarName carName : carNames) {
            builder.append(carName.name());
            builder.append(",");
        }
        String substring = builder.substring(0, builder.length() - 1);
        System.out.println(substring);
    }
}
