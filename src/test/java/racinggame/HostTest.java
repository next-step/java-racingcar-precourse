package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

}
