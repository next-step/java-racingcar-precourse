package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import racinggame.view.CarInput;

public class CarsTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	void 정상_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi,woni");
			Cars cars = Cars.init(CarInput.getInput());
			assertThat(cars.value().size()).isEqualTo(2);
			assertThat(cars.value().get(0).toString()).contains("pobi");
			assertThat(cars.value().get(1).toString()).contains("woni");
			verify(CarInput.GUIDE_MESSAGE);
		});
	}

	@Test
	void 다섯_글자_이상의_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi1234,woni", "pobi,woni");
			Cars.init(CarInput.getInput());
			verify(CarInput.GUIDE_MESSAGE, CarName.ERROR_MESSAGE);
		});
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	protected void runMain() {
	}
}
