import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static CarStatus getCarStatus(int number) {
        if (number > 3) {
            return CarStatus.MOVE;
        }

        return CarStatus.STOP;
    }

    public static boolean carStatusEqualsGoalCheck(Car car) {
        if (CarStatus.GOAL == car.getCarStatus()) {
            return true;
        }

        return false;
    }

    public static List<Car> getCarStatusEqualsGoal(List<Car> cars) {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            if (carStatusEqualsGoalCheck(car)) {
                carList.add(car);
            }
        }

        return carList;
    }

    public static boolean carNameValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + ": 이름이 5자리 이상입니다.");
        }

        return true;
    }

    public static boolean inputCarSizeValid(List<String> names) {
        if (names.size() <= 0) {
            throw new IllegalArgumentException("1개 이상의 자동차 이름을 입력해주세요.");
        }
        return true;
    }

    public static boolean inputCarNameDuplicateValid(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);

        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }

        return true;
    }

    public static boolean commaCountCompareToNames(List<String> names, int commaCount) {
        if (names.size() - 1 != commaCount) {
            throw new IllegalArgumentException("쉼표(,) 구분을 정확히 해주세요.");
        }
        return true;
    }

    public static List<String> splitInputCarNames(String inputNames) {
        List<String> names = new ArrayList<>();
        int commaCount = 0;
        int start = 0;
        int end = 0;

        int inputStringSize = inputNames.length();

        for (int i = 0; i < inputStringSize; i++) {
            if (inputNames.charAt(i) == ',') {
                commaCount++;
                end = i;
                names.add(inputNames.substring(start, end));
                start = i + 1;
                continue;
            }

            if (i == inputStringSize - 1) {
                end = i + 1;
                names.add(inputNames.substring(start, end));
                break;
            }
        }

        commaCountCompareToNames(names, commaCount);

        return names;
    }
}
