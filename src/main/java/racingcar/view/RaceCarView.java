package racingcar.view;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

public class RaceCarView {

    private static final String raceMark = "-";
    private final UserString name;
    private final NaturalNumber position;

    private RaceCarView(UserString name, NaturalNumber position) {
        this.name = name;
        this.position = position;
    }

    public static RaceCarView of(UserString name, NaturalNumber position) {
        return new RaceCarView(name, position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(position.get());
        for (int i = 0; i < this.position.get(); i++) {
            sb.append(raceMark);
        }
        return String.format("%s : %s", this.name, sb);
    }

    public String getName() {
        return this.name.toString();
    }
}
