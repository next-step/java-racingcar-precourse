package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class CarNameInputTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	void 정상_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi,woni");
			CarNameInput.init();
			verify(CarNameInput.GUIDE_MESSAGE);
		});
		assertThat(CarNameInput.values().size()).isEqualTo(2);
		assertThat(CarNameInput.values()).contains("pobi", "woni");
	}

	@Test
	void 다섯_글자_이상의_자동차_입력() {
		assertSimpleTest(() -> {
			run("pobi1234,woni", "pobi,woni");
			CarNameInput.init();
			verify(CarNameInput.GUIDE_MESSAGE, CarNameInput.ERROR_MESSAGE);
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
