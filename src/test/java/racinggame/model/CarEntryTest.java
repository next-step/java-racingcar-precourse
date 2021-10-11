package racinggame.model;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarEntryTest {

	@Test
	@DisplayName("자동차 목록 생성 검증")
	void createCarListTest() {
		List<String> carsNameList = Arrays.asList("car1", "car2", "car3");
		CarEntry carEntry = new CarEntry(carsNameList);
		assertThat(carEntry).isNotNull();
	}

	@Test
	void 경주_후_결과_검증() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(6, 1);
			CarEntry carEntry = new CarEntry(Arrays.asList("car1", "car2"));
			carEntry.race();
			List<String> result = carEntry.getResult();
			assertThat(result).isEqualTo(Arrays.asList("car1 : -", "car2 : "));
		}
	}

	@Test
	void 승자_검증() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(6, 1);
			CarEntry carEntry = new CarEntry(Arrays.asList("car1", "car2"));
			carEntry.race();
			assertThat(carEntry.getWinner()).isEqualTo("car1");
		}
	}

	@Test
	void 다중_승자_검증() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(6, 5);
			CarEntry carEntry = new CarEntry(Arrays.asList("car1", "car2"));
			carEntry.race();
			assertThat(carEntry.getWinner()).isEqualTo("car1,car2");
		}
	}

}
