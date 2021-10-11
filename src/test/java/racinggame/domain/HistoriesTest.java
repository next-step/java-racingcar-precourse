package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class HistoriesTest {
	@Test
	void countTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(4, 3, 4);
			Car pobi = new Car(Name.of("pobi"));
			Car crong = new Car(Name.of("crong"));
			Car honux = new Car(Name.of("honux"));
			Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
			Game game = Game.ready(cars);
			game.start(Count.of(1));
			Histories histories = new Histories();
			histories.log(game);
			histories.log(game);
			histories.log(game);
			Iterator<History> itr = histories.iterator();
			assertThat(itr.hasNext())
					.isTrue();
			itr.next();
			assertThat(itr.hasNext())
					.isTrue();
			itr.next();
			assertThat(itr.hasNext())
					.isTrue();
			itr.next();
			assertThat(itr.hasNext())
					.isFalse();
		}
	}
}
