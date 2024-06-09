import java.util.IllegalFormatException;
import java.util.List;

public class CheckInput {
    public static boolean checkCarNames(List<String> carNames) {
        for (String carName : carNames) {
            int carLength = carName.length();
            if ((carLength < 1) || (carLength > 5)) {
                CheckInput.isWrongValue();
                return false;
            }
        }
        return true;
    }

   /* public static boolean checkInt(String intNum) {
        try {
            Integer.parseInt(intNum);
            return true;
        } catch (IllegalFormatException e) {
            CheckInput.isWrongValue();
            return false;
        }
    }*/

    public static void isWrongValue() {
        throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. 다시 입력하세요.");

    }



}
