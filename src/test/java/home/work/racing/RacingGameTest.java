package home.work.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.GameCount;

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

	private final RacingGame makeRacingGame(String names, int count) {
		Scanner mock = mock(Scanner.class);
		when(mock.next()).thenReturn(names);
		when(mock.nextInt()).thenReturn(count);
		CommandLineInterface cli = new CommandLineInterface(mock);
		return new RacingGame(cli);
	}
	
}
