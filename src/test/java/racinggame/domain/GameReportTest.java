package racinggame.domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameReportTest {
	@DisplayName("우승자 이름을 알 수 있다")
	@Test
	void given_result_then_report_winner_name() {
		List<CarDto> gameResult = Arrays.asList(new CarDto("Red", 1), new CarDto("Blue", 2), new CarDto("Green",2));

		GameReport report = new GameReport(gameResult);
		String names = report.reportWinnersNames();

		Assertions.assertThat(names).isEqualTo("Blue,Green");
	}
}
