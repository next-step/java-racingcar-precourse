package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class CarInputTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	void 정상_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi,woni");
			CarInput.init();
			verify(CarInput.GUIDE_MESSAGE);
		});
		assertThat(CarInput.values().size()).isEqualTo(2);
		assertThat(CarInput.values().get(0).toString()).contains("pobi");
		assertThat(CarInput.values().get(1).toString()).contains("woni");
	}

	@Test
	void 다섯_글자_이상의_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi1234,woni", "pobi,woni");
			CarInput.init();
			verify(CarInput.GUIDE_MESSAGE, CarInput.ERROR_MESSAGE);
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
