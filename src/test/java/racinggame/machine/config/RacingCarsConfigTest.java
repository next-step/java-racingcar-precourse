package racinggame.machine.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.test.NSTest;
import racinggame.machine.input.ConsoleKeyboard;
import racinggame.machine.output.ConsolePrinter;

class RacingCarsConfigTest extends NSTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private RacingCarsConfig config;

	@BeforeEach
	void beforeEach() {
		setUp();

		config = TestRacingCarsConfig.config();
	}

	@DisplayName("에러발생 - 잘못된 입력을 하는 경우")
	@ParameterizedTest
	@ValueSource(strings = {" ,  ,   ,    ,", ",,,,,", ",,,,a", "a,,,t", "    ", "\n"})
	void commaTest(String input) {
		assertSimpleTest(() -> {
			runNoLineFound(input);
			verify(ERROR_MESSAGE);
		});
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	protected void runMain() {
		config.getRacingCars();
	}

	private static class TestRacingCarsConfig {
		static RacingCarsConfig config() {
			return new RacingCarsConfig(new ConsoleKeyboard(), new ConsolePrinter());
		}
	}
}