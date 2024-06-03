import java.util.Arrays;
import java.util.List;

public class NameValidator {
    public List<String> validateAndGetNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = Arrays.stream(names).map(String::trim).distinct().toList();

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        if (carNames.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }

        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return carNames;
    }
}
