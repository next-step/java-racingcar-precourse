package racingcar.domain.car;

import racingcar.domain.InputData;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<Car> carList = new ArrayList<>();

    private static Cars cars = new Cars();

    public static Cars getInstance() {
        return cars;
    }

    public static void createCar(InputData inputData) {
        String[] carArr = inputData.getInputData().split(",");
        for (int i = 0; i < carArr.length; i++) {
            Car car = new Car(carArr[i]);
            carList.add(car);
        }
    }

    public int getCarsSize() {
        return carList.size();
    }

    public List<Car> getCars() {
        return carList;
    }

    public Car getCars(int index) {
        if (carList.get(index) == null) {
            return null;
        }
        return carList.get(index);
    }

    public static void Test_init(){
        carList = new ArrayList<>();
    }
}
