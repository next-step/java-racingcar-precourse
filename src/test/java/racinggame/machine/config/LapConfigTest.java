package racinggame.machine.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.test.NSTest;
import racinggame.circuit.Lap;
import racinggame.machine.input.ConsoleKeyboard;
import racinggame.machine.output.ConsolePrinter;

class LapConfigTest extends NSTest {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private LapConfig config;

	@BeforeEach
	void beforeEach() {
		setUp();
		config = TestLapConfig.config();
	}

	@DisplayName("입력성공 - 양수")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "100"})
	void positiveNumberTest(String input) {
		assertSimpleTest(() -> {
			run(input);
			verify(input);
		});
	}

	@DisplayName("에러발생 - 0, 음수 입력")
	@ParameterizedTest
	@ValueSource(strings = {"0", "-1", "-100"})
	void commaTest(String input) {
		assertSimpleTest(() -> {
			runNoLineFound(input);
			verify(ERROR_MESSAGE);
		});
	}

	@DisplayName("에러발생 - 문자입력")
	@ParameterizedTest
	@ValueSource(strings = {"a", "b", "c", "d", "abc"})
	void characterTest(String input) {
		assertSimpleTest(() -> {
			runNoLineFound(input);
			verify(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		Lap lap = config.getLaps();
		System.out.println(lap.getLaps());
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	private static class TestLapConfig {
		static LapConfig config() {
			return new LapConfig(new ConsoleKeyboard(), new ConsolePrinter());
		}
	}
}