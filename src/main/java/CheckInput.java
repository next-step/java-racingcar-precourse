import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.List;

public class CheckInput {
    public static boolean checkCarNames(List<String> carNames) {
        if(!checkCarNameDiffer(carNames)){
            return false;
        }
        for (String carName : carNames) {
            int carLength = carName.length();
            if(!checkCarNameLength(carName)){
                return false;
            };
        }
        return true;
    }

    public static boolean checkCarNameDiffer(List<String> carNames) {
        boolean check = true;
        HashSet<String> setNames = new HashSet<>(carNames);
        if (setNames.size() != carNames.size()) {
            check=false;
            throw new IllegalStateException("[ERROR] 자동차의 이름은 모두 다르게 입력해주세요.");
        }
        return check;
    }

    public static boolean checkCarNameLength(String name) {
        boolean result = true;
        if ((name.length() < 1) || (name.length() > 5)) {
            result=  false;
            throw new IllegalArgumentException("[ERROR] 차 이름의 길이는 1글자~5글자 사이로 입력해주세요.");
        }
        return result;
    }

    public static void isWrongIntValue(int tryNum) {
        if (tryNum < 1) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. 1이상의 정수를 다시 입력하세요.");
        }
    }
}
