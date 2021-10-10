package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import nextstep.utils.Randoms;

@DisplayName("Record 클래스")
class RecordTest {

	Map<String, Record> recordPerWinner= new HashMap<>();

	@BeforeEach
	void setTestData() {
		recordPerWinner.put("car1", createRecord(4, 1, 1));
		recordPerWinner.put("car2", createRecord(1, 4, 1));
		recordPerWinner.put("car3", createRecord(1, 1, 4));
		recordPerWinner.put("car1,car2", createRecord(4, 4, 1));
		recordPerWinner.put("car1,car3", createRecord(4, 1, 4));
		recordPerWinner.put("car1,car2,car3", createRecord(4, 4, 4));
	}

	Record createRecord(int... randomNumbers) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			LineUp lineUp = new LineUp(
				Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3")));

			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(randomNumbers[0], randomNumbers[1], randomNumbers[2]);

			lineUp.drive();
			return lineUp.getRecord();
		}
	}

	@Nested
	@DisplayName("award 메소드는")
	class DescribeAward {

		@Nested
		@DisplayName("호출되면")
		class ContextWinnerCar {

			@ParameterizedTest(name = "[{index}] 우승:{0}")
			@ValueSource(strings = {"car1", "car2", "car3", "car1,car2", "car1,car3", "car1,car2,car3"})
			@DisplayName("가장많이 이동한 자동차이름을 출력한다")
			void it_print_winner(String expected) {
				Record record = recordPerWinner.get(expected);
				assertThat(record).isNotNull();

				String[] actual = record.awardTo().split(",");
				assertThat(actual).contains(expected.split(","));

			}
		}

		@Nested
		@DisplayName("호출되면")
		class ContextDefeatCar {

			@ParameterizedTest(name = "[{index}] 우승: {0}, 나미지: {1}")
			@CsvSource(value = {"car1|car2, car3", "car1,car2|car3"}, delimiter = '|')
			@DisplayName("우승못한 자동차이름은 출력하지 않는다")
			void it_print_winner(String expectedWinner, String expectedLooser) {
				Record record = recordPerWinner.get(expectedWinner);
				assertThat(record).isNotNull();

				String[] actualWinner = record.awardTo().split(",");
				assertThat(actualWinner).doesNotContain(expectedLooser.split(","));

			}
		}
	}
}
