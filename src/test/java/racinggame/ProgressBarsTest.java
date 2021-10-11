package racinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ProgressBarsTest {

	@Test
	void 모든_자동차들의_진행상태를_출력한다() {
		ProgressBar progressA = new ProgressBar(new CarName("carA"), new RacingBar(2));
		ProgressBar progressB = new ProgressBar(new CarName("carB"), new RacingBar(4));
		ProgressBar progressC = new ProgressBar(new CarName("carC"), new RacingBar(3));

		ProgressBars progressBars = new ProgressBars(Arrays.asList(progressA, progressB, progressC));

		String expectString = progressA + "\n" + progressB + "\n" + progressC + "\n";
		assertThat(progressBars.toString()).isEqualTo(expectString);
	}
}
