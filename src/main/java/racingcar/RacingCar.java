package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {
    private static InputOutput io = new InputOutput();
    private static List<String> carNameList;
    private static List<Car> carList = new ArrayList<>();
    private static int attemptsCount;

    public static void run() {
        carNameList = separateName(io.input());
        attemptsCount = Integer.parseInt(io.input());

        initCar();
    }

    private static void initCar() {
        for (int i = 0; i < carNameList.size(); i++) {
            carList.add(new Car("", carNameList.get(i)));
        }
    }

    public static List<String> separateName(String input) {
        List<String> carNameList = Arrays.asList(input.split(","));

        return carNameList;
    }

    public static boolean checkLen(String carName) {
        if(carName.length() <= 5) {
            return true;
        }
        return false;
    }
}
