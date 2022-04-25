package racingcar.logic;

import java.util.Collection;
import java.util.Objects;

public interface GameLogic {

	boolean process(Object origin, Object value);

	Object generateNumbers();

}
