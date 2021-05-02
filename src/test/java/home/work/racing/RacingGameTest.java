package home.work.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.CarMove;
import home.work.racing.wrap.CarName;
import home.work.racing.wrap.GameCount;
import home.work.racing.wrap.RandomResult;

public class RacingGameTest {

	@Test
	final void testRacingGameWithNull() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new RacingGame(null);
		});
	}

	@Test
	final void testInit() {
		String input = "a,b,c";
		int count = 5;
		RacingGame game = this.makeRacingGame(input, count);
		assertThat(game).isNotNull();
		game.init();
		assertThat(game).extracting("gameCount").asInstanceOf(InstanceOfAssertFactories.type(GameCount.class))
				.extracting("count").isEqualTo(count);
		assertThat(game).extracting("cars").asInstanceOf(InstanceOfAssertFactories.type(PlayerCars.class))
				.extracting("cars").asList().hasSize(input.split(",").length);
	}
	
	@Test
	final void testCheck() {
		String input = "a,b,c";
		int count = 5;
		RacingGame spy = this.makeSpyRacingGame(input, count);
		PlayerCar car = new PlayerCar(new CarName("a"));
		spy.check(new RandomResult(3), car);
		assertThat(car).extracting("move").asInstanceOf(InstanceOfAssertFactories.type(CarMove.class))
				.extracting("move").asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(0);
		spy.check(new RandomResult(4), car);
		assertThat(car).extracting("move").asInstanceOf(InstanceOfAssertFactories.type(CarMove.class))
				.extracting("move").asInstanceOf(InstanceOfAssertFactories.INTEGER).isEqualTo(1);
	}

	@Test
	final void testRoll() {
		String input = "a,b,c";
		int count = 5;
		RacingGame spy = this.makeSpyRacingGame(input, count);
		doNothing().when(spy).check(any(RandomResult.class), any(PlayerCar.class));
		spy.roll();
		verify(spy, times(input.split(",").length)).check(any(RandomResult.class), any(PlayerCar.class));
	}
	
	@Test
	final void testStart() {
		String input = "a,b,c";
		int count = 5;
		RacingGame game = this.makeRacingGame(input, count);
		game.init();
		RacingGame spyGame = spy(game);
		doNothing().when(spyGame).roll();
		spyGame.start();
		verify(spyGame, times(count)).roll();
	}

	@Test
	final void testPlay() {
		String input = "a,b,c";
		int count = 5;
		RacingGame spy = this.makeSpyRacingGame(input, count);
		doNothing().when(spy).init();
		doNothing().when(spy).start();
		doNothing().when(spy).showResult();
		spy.play();
		verify(spy, times(1)).init();
		verify(spy, times(1)).start();
		verify(spy, times(1)).showResult();
	}

	@Test
	final void testShowResult() {
		String input = "a,b,c";
		int count = 5;
		Scanner scannerMock = mock(Scanner.class);
		when(scannerMock.next()).thenReturn(input);
		when(scannerMock.nextInt()).thenReturn(count);
		CommandLineInterface cliSpy = spy(new CommandLineInterface(scannerMock));
		RacingGame game = new RacingGame(cliSpy);
		game.init();
		mockStatic(RandomUtils.class).when(RandomUtils::random).thenReturn(new RandomResult(4));
		for (int i = 0; i < count; i++) {
			game.roll();
		}
		game.showResult();
		ArgumentCaptor<RaceWinners> captor = ArgumentCaptor.forClass(RaceWinners.class);
		verify(cliSpy).printWinners(captor.capture());
		assertThat(Optional.ofNullable(captor).map(ArgumentCaptor::getValue).map(RaceWinners::getCars)
				.map(PlayerCars::getCars).map(List::size).orElse(-1)).isEqualTo(Arrays.asList(input.split(",")).size());
		assertThat(Optional.ofNullable(captor).map(ArgumentCaptor::getValue).map(RaceWinners::getWinnerMove)
				.map(CarMove::getMove).orElse(-1)).isEqualTo(count);
	}

	private final RacingGame makeRacingGame(String names, int count) {
		Scanner mock = mock(Scanner.class);
		when(mock.next()).thenReturn(names);
		when(mock.nextInt()).thenReturn(count);
		CommandLineInterface cli = new CommandLineInterface(mock);
		return new RacingGame(cli);
	}

	private final RacingGame makeSpyRacingGame(String names, int count) {
		RacingGame game = this.makeRacingGame(names, count);
		game.init();
		return spy(game);
	}
	
}
