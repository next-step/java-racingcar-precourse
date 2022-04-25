package racingcar.domain.racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class RacingCarRepositoryTest extends NsTest {
	private RacingCar racingCar;
	private Map<String, RacingCar> racingCarMap = new HashMap<>();

	@BeforeEach
	void setUp() {
		racingCar = new RacingCar("pobi");
	}

	@Test
	void RacingCar_생성_시_이름_검증() {
		String carName = "";
		assertThrows(IllegalStateException.class, () -> new RacingCar(carName));
		assertEquals("pobi", racingCar.getCarName());
	}

	@Test
	void racingCar의_이름을_key로_지정하여_save() {
		racingCarMap.put("woni", new RacingCar("woni"));
		assertEquals("woni",  racingCarMap.get("woni").getCarName());
	}

	@Override
	protected void runMain() {

	}
}
