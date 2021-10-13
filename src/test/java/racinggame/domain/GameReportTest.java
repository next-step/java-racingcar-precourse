package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameReportTest {
	@DisplayName("우승자 이름을 알 수 있다")
	@Test
	void given_result_then_report_winner_name() {
		List<RacingCarDto> gameResult = Arrays.asList(new RacingCarDto("Red", 1),
			new RacingCarDto("Blue", 2),
			new RacingCarDto("Green",2));

		GameReport report = new GameReport(gameResult);
		String names = report.reportWinnersNames();
		assertThat(names).isEqualTo("Blue,Green");
	}
}