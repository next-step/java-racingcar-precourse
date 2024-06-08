import java.util.List;

public class CheckCarNames {
    public static void checkCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
