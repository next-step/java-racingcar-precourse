package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	@DisplayName("차를 전진시킨뒤 출력 값 확인")
	void carTest() {
		String name = "페라리";
		Car car = new Car(name);
		car.move(() -> true);
		car.move(() -> true);
		car.move(() -> true);
		car.move(() -> false);
		car.printCurrentStatus();
		assertThat("페라리 : ---").isEqualTo(outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
}
