package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.view.UserConsole;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserConsoleTest {
	private PrintStream standardOut;
	private OutputStream captor;

	@BeforeEach
	void beforeEach() {
		standardOut = System.out;
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@Test
	void 자동차이름_1개_입력() {
		String input = "pobi";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		String[] carNames = UserConsole.readCarNames();
		assertThat(carNames[0]).isEqualTo("pobi");
	}

	@Test
	void 자동차이름_여러개_입력() {
		String input = "pobi,crong,honux";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		String[] carNames = UserConsole.readCarNames();
		assertThat(carNames[0]).isEqualTo("pobi");
		assertThat(carNames[1]).isEqualTo("crong");
		assertThat(carNames[2]).isEqualTo("honux");
	}

	@Test
	void 시도_횟수_입력() {
		String input = "2147483647";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		int trialNumber = UserConsole.readTrialNumber();
		assertThat(trialNumber).isEqualTo(2147483647);
	}


	@Test
	void 시도_횟수_입력_Integer범위_벗어난_경우() {
		String input = "2147483648";
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		assertThatThrownBy(() -> {
			UserConsole.readTrialNumber();
		}).isInstanceOf(NumberFormatException.class)
				.hasMessageContaining("[ERROR]");
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
	}
}
