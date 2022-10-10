package racingcar.validators;

import java.util.regex.Pattern;

public class GameCountValidator implements Validator {
    private final String gameCount;

    public GameCountValidator(String gameCount) {
        this.gameCount = gameCount;
    }

    @Override
    public void validate() throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[1-9]+$");
        boolean isNumeric = pattern.matcher(this.gameCount).matches();
        if (!isNumeric) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
