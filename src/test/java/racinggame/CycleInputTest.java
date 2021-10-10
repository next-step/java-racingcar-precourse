package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class CycleInputTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		setUp();
	}

	@Test
	void 정상_숫자_입력() {
		assertSimpleTest(() -> {
			run("10");
			CycleInput.init();
			verify(CycleInput.GUIDE_MESSAGE);
		});
		assertThat(CycleInput.value().cycle()).isEqualTo(10);
	}

	@Test
	void 문자_입력() {
		assertSimpleTest(() -> {
			run("number", "100");
			CycleInput.init();
			verify(CycleInput.GUIDE_MESSAGE, CycleInput.ERROR_MESSAGE);
		});
	}

	@Test
	void _1_이하인_숫자_입력() {
		assertSimpleTest(() -> {
			run("0", "1000");
			CycleInput.init();
			verify(CycleInput.GUIDE_MESSAGE, CycleInput.ERROR_MESSAGE);
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
