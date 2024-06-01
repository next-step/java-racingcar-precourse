package Controller;

import java.util.List;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");

        }
    }

    public static void validateTrialCount(int count) {
        if (count <= 0) throw new IllegalArgumentException("시도할 회수는 양의 정수여야 합니다.");

    }


}
