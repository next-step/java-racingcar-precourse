package controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.*;
import view.*;

public class GameController {

    public static void startGame() {
        String[] carNamesArray = getCarNames(InputView.getFristInput());
        int n = InputView.getSecondInput();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Car car = new Car(carNamesArray[i]);
            cars.add(car);
        }
    }

    public static String[] getCarNames(String input) {
        String[] result = input.replaceAll("\\s+", "").split(",");
        return result;
    }

    public static boolean checkCarNameLength(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            return false;
        }
        return true;
    }
}
