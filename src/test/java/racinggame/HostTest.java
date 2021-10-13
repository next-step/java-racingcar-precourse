package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racinggame.common.ErrorMessage.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.utils.Console;
import racinggame.controller.Host;
import racinggame.domain.Car;
import racinggame.domain.Racing;

public class HostTest {
	private static MockedStatic<Console> mockConsole;
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static PrintStream originalOut = System.out;

	Host host;

	@BeforeAll
	static void beforeAll() {
		mockConsole = mockStatic(Console.class);
		System.setOut(new PrintStream(outContent));
	}

	@AfterAll
	static void afterAll() {
		mockConsole.close();
		System.setOut(new PrintStream(originalOut));
	}

	@BeforeEach
	void setUp() {
		host = new Host();
	}

	@Test
	void 레이싱_참가() {
		String input = "pobi,crong,honux";

		mockConsole.when(Console::readLine)
			.thenReturn(input);

		host.setRacingCars();
		Racing racing = host.getRacing();
		List<Car> carList = racing.getCars().getCarList();

		assertThat(carList)
			.hasSize(3)
			.asString()
			.contains("pobi")
			.contains("crong")
			.contains("honux");
	}

	@ParameterizedTest(name = "자동차_이름_입력 {0}")
	@ValueSource(strings = {"", "123456,안녕하세요", ",안녕,", "123,"})
	void 레이싱_자동차_이름_입력_유효성(String input) {
		mockConsole.when(Console::readLine)
			.thenReturn(input);

		host.setRacingCars();

		String output = outContent.toString();
		assertThat(output)
			.contains(ERROR_PREFIX)
			.contains(ERROR_INPUT_CAR_NAMES);

	}

	@ParameterizedTest(name = "시도횟수_입력 {0}")
	@ValueSource(strings = {"1", "3", "4", "5"})
	void 시도횟수_입력(String input) {
		mockConsole.when(Console::readLine)
			.thenReturn(input);

		host.setTryCount();

		assertThat(host.getRacing())
			.extracting("tryCount")
			.extracting("tryCount")
			.isEqualTo(Integer.parseInt(input));
	}

	@ParameterizedTest(name = "시도횟수_입력_유효성 {0}")
	@ValueSource(strings = {"011", "a", "", "%%"})
	void 시도횟수_입력_유효성(String input) {
		mockConsole.when(Console::readLine)
			.thenReturn(input);

		String output = outContent.toString();
		assertThat(output)
			.contains(ERROR_PREFIX)
			.contains(ERROR_TRY_COUNT);
	}

}
