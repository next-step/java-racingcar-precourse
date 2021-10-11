package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProgressBarTest {

	@Test
	void 자동차의_경주_진행상태를_출력한다() {
		ProgressBar progressBar = new ProgressBar("carA", new RacingBar(2));

		assertThat(progressBar.toString()).isEqualTo("carA : --");
	}
}
