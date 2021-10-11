package racinggame.domain;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class HistoryTest {
	@Test
	void createTest() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(4, 3, 4);
			Car pobi = new Car(Name.of("pobi"));
			Car crong = new Car(Name.of("crong"));
			Car honux = new Car(Name.of("honux"));
			Cars cars = new Cars(Arrays.asList(pobi, crong, honux));
			Game game = Game.ready(cars);
			game.start(Count.of(1));
			History history = History.of(game);
			Set<Name> names = history.keySet();
			assertThat(names.size())
					.isEqualTo(3);
			Iterator<Name> itr = names.iterator();
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(history.get(itr.next()))
					.isEqualTo(Distance.of(1));
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(history.get(itr.next()))
					.isEqualTo(Distance.of(0));
			assertThat(itr.hasNext())
					.isTrue();
			assertThat(history.get(itr.next()))
					.isEqualTo(Distance.of(1));
			assertThat(itr.hasNext())
					.isFalse();
		}
	}
}
