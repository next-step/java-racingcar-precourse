package racinggame.ui;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;
import racinggame.exception.InvalidNumberException;

class RacingGameScreenTest extends NSTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	private RacingGameScreen screen;

	@BeforeEach
	void beforeEach (){
		setUp();

		screen = new RacingGameScreen();
	}

	@DisplayName("자동차 이름, 랩 등록 성공")
	@Test
	void success (){
		assertSimpleTest(() -> run("pobi,woni", "1"));
	}

	@DisplayName("레이싱카 이름이 5자를 초과하면 [ERROR]가 발생한다.")
	@Test
	void racingCarNameFail() {
		assertSimpleTest(() -> {
			runNoLineFound("pobi,javaji");
			verify(ERROR_MESSAGE);
		});
	}

	@DisplayName("랩 수를 0이하 음수를 등록하면 [ERROR]가 발생한다.")
	@Test
	void wrongLaps (){
		assertSimpleTest(() -> {
			assertThatThrownBy(() -> run("pobi,woni", "0"))
				.isInstanceOf(InvalidNumberException.class)
				.hasMessage("[ERROR] 1 이상 자연수를 입력하세요.");
		});
	}

	@Override
	protected void runMain() {
		screen.on();
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}
}