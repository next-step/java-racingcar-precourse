import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.List;

public class CheckInput {

    public static void checkCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 자동차를 2대 이상 적어야 경주가 시작됩니다.");
        }
    }

    public static void checkCarNames(List<String> carNames) {
        checkCarNameDiffer(carNames);
        for (String carName : carNames) {
            int carLength = carName.length();
            checkCarNameLength(carName);
        }
    }

    public static void checkCarNameDiffer(List<String> carNames) {
        HashSet<String> setNames = new HashSet<>(carNames);
        if (setNames.size() != carNames.size()) {
            throw new IllegalStateException("[ERROR] 자동차의 이름은 모두 다르게 입력해주세요.");
        }
    }

    public static void checkCarNameLength(String name) {
        if ((name.isEmpty()) || (name.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 차 이름의 길이는 1글자~5글자 사이로 입력해주세요.");
        }
    }

    public static void isWrongIntValue(int tryNum) {
        if (tryNum < 1) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. 1이상의 정수를 다시 입력하세요.");
        }
    }
}
