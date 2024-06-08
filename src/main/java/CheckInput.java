import java.util.List;

public class CheckInput {
    public static boolean checkCarName(List<String> carNames) {
        for (String carName : carNames) {
            int carLength = carName.length();
            if ((carLength < 0) || (carLength > 5)) {
                CheckInput.isWrongValue();
                return false;
            }
        }
        return true;
    }

}
