package home.work.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Scanner;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import home.work.racing.plural.CarNames;
import home.work.racing.wrap.CarMove;
import home.work.racing.wrap.CarName;
import home.work.racing.wrap.GameCount;

public class CommandLineInterfaceTest {

	@Test
	final void testCommandLineInterface() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new CommandLineInterface(null);
		}).withMessageContaining("입력기");
	}

	@Test
	final void testReceiveCarNames() {
		String inputValue = "abcde,가나다라마,12345,d,e,,,,";
		String[] splitedInput = inputValue.split(",");
		Scanner mock = mock(Scanner.class);
		when(mock.next()).thenReturn(inputValue);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		CarNames result = testTarget.receiveCarNames();
		assertThat(result).isNotNull().extracting("names").asList().hasSameSizeAs(splitedInput).extracting("name")
				.containsAll(Arrays.asList(splitedInput));
	}
	
	@Test
	final void testReceiveCarNames2() {
		String inputValue = ",,,,";
		Scanner mock = mock(Scanner.class);
		when(mock.next()).thenReturn(inputValue);
		CarNames result = new CommandLineInterface(mock).receiveCarNames();
		assertThat(result).isNotNull().extracting("names").asList().hasSize(0);
	}

	@Test
	final void testReceiveCarNamesWrongInput() {
		String inputValue = "가나다라마바사아,자차카타파하,123";
		Scanner mock = mock(Scanner.class);
		when(mock.next()).thenReturn(inputValue);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		assertThatIllegalArgumentException().isThrownBy(() -> {
			testTarget.receiveCarNames();
		});
	}

	@Test
	final void testReceiveGameCount() {
		int inputValue = Integer.MIN_VALUE;
		Scanner mock = mock(Scanner.class);
		when(mock.nextInt()).thenReturn(inputValue);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		GameCount result = testTarget.receiveGameCount();
		assertThat(result).isNotNull().extracting("count").asInstanceOf(InstanceOfAssertFactories.INTEGER)
				.isEqualTo(inputValue);
	}

	@Test
	final void testPrintCarMovingWithNull() {
		Scanner mock = mock(Scanner.class);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> {
				testTarget.printCarMoving(null);
			});
	}
	
	@Test
	final void testPrintWinners() {
		Scanner mock = mock(Scanner.class);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		CarMove winnerMove = this.getCarMove(5);
		RaceWinners raceWinners = new RaceWinners(winnerMove);
		raceWinners.addCar(new PlayerCar(new CarName("a")));
		RaceWinners winners = raceWinners;
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				testTarget.printWinners(winners);
			});
	}

	@Test
	final void testPrintWinnersWithNull() {
		Scanner mock = mock(Scanner.class);
		CommandLineInterface testTarget = new CommandLineInterface(mock);
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> {
				testTarget.printWinners(null);
			});
	}
	
	private final CarMove getCarMove(int count) {
		CarMove move = new CarMove();
		for (int i = 0; i < count; i++) {
			move.moving();
		}
		return move;
	}

}
