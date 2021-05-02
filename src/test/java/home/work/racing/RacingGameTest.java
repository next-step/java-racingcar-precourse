package home.work.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

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
		spy.play();
		verify(spy, times(1)).init();
		verify(spy, times(1)).start();
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
