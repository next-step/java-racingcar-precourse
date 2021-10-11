package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class UserInputTest {
	@Test
	void 자동차_이름_입력_테스트() {
		String userInputFirst = "pobi,tothemoon,mike";
		String userInputSecond = "pobi,moon,mike";

		assertThatIllegalArgumentException().isThrownBy(() -> new CarNames(userInputFirst));

		assertThat(new CarNames(userInputSecond).getNames()).isEqualTo(Arrays.asList("pobi", "moon", "mike"));

	}

	@Test
	void 횟수_입력_테스트() {
		String userInputFirst = "a";
		String userInputSecond = "5";

		assertThatIllegalArgumentException().isThrownBy(() -> new RacingCount(userInputFirst));

		assertThat(new RacingCount(userInputSecond).getCount()).isEqualTo(5);
	}
}
