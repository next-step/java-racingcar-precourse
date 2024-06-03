import java.util.List;
import java.util.Vector;

public class InputValidator {

    public static boolean validateCarName(Vector<Car> cars) throws IllegalArgumentException {
        List<Car> invalidCar = cars.stream().filter(Car -> Car.getName().length() > 5).toList();

        if (invalidCar.size() > 0) {
            cars.clear();
            throw new IllegalArgumentException("[ERROR] : 자동차 이름의 글자 수는 5글자 이하만 가능합니다.");
        }
        return true;
    }

    public static boolean validateAttemptCount(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] : 시도할 횟수는 양수만 가능합니다.");
        }
        return true;
    }

}
