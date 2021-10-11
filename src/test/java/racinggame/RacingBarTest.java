package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingBarTest {

	private RacingBar bar;

	@BeforeEach
	void setup() {
		bar = new RacingBar(0);
	}

	@Test
	void 랜덤숫자가_3이하이면_추가하지_않는다() {
		int randomNo = 3;
		bar.addBy(randomNo);
		int currentBar = bar.getCurrentBar();

		assertThat(currentBar).isEqualTo(0);
	}

	@Test
	void 랜덤숫자가_4이상이면_추가한다() {
		int randomNo = 4;
		bar.addBy(randomNo);
		int currentBar = bar.getCurrentBar();

		assertThat(currentBar).isEqualTo(1);
	}

	@Test
	void 랜덤숫자에_따라_축적된다() {
		int randomNo = 4;
		bar.addBy(randomNo);
		randomNo = 5;
		bar.addBy(randomNo);
		int currentBar = bar.getCurrentBar();

		assertThat(currentBar).isEqualTo(2);
	}

}
