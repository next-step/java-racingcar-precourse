package racinggame.domain.strategy;

import nextstep.utils.Randoms;
import racinggame.common.ConstValue;

public class MoveTestStayStrategy implements Strategy{

	@Override
	public boolean isMovable() { return false; }
}
