package racingcar.game.internal;

import racingcar.game.util.AbstractMutableList;

import java.util.Arrays;
import java.util.List;

public class Strings extends AbstractMutableList<String> {
    public Strings(List<String> list) {
        super(list);
    }

    public Strings(String[] strings) {
        this(Arrays.asList(strings));
    }
}
