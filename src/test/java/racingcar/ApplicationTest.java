package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 전진_정지() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni", "1");
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(
			() -> {
				runException("pobi,javji");
				assertThat(output()).contains(ERROR_MESSAGE);
			}
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[]{});
	}


}
