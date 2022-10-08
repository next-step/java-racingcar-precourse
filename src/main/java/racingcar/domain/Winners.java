package racingcar.domain;

import java.util.List;

public class Winners {
    public static final int COMMA_AND_WHITE_SPACE_LENGTH = 2;
    private final List<CarName> winnersName;

    public Winners(List<CarName> names) {
        this.winnersName = names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CarName name : winnersName) {
            sb.append(String.format("%s, ", name));
        }
        return sb.substring(0, sb.length() - COMMA_AND_WHITE_SPACE_LENGTH);
    }
}
