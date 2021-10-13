package racinggame;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static racinggame.common.CommonConstants.*;
import static racinggame.common.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;
import racinggame.domain.Car;
import racinggame.domain.CarNames;
import racinggame.domain.Racing;
import racinggame.domain.RacingResults;
import racinggame.domain.TryCount;
import racinggame.domain.Winners;

public class RacingTest {

	private static MockedStatic<Randoms> mockRandoms;
	Racing racing;

	@BeforeAll
	static void beforeAll() {
		mockRandoms = mockStatic(Randoms.class);
	}

	@AfterAll
	static void afterAll() {
		mockRandoms.close();
	}

	@BeforeEach
	void setUp() {
		racing = new Racing();
		racing.joinList(new CarNames("Lee,Park,Kim,제이,논,진"));
	}

	@Test
	void 레이싱_참가() {
		int size = 7;
		Car car = new Car("wow");

		racing.join(car);

		assertThat(racing.getCars().getCarList())
			.hasSize(size);
	}

	@Test
	void 레이싱_참가_목록() {
		int size = 8;
		List<String> names = Arrays.asList("wow", "와우");
		CarNames carNames = new CarNames("wow,와우");

		racing.joinList(carNames);

		assertThat(racing.getCars().getCarList())
			.hasSize(size);
	}

	@Test
	void 레이싱_한번단위() {
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1, 2, 3, 4, 5, 6);

		racing.run();

		RacingResults result = racing.getRacingResults();
		assertThat(result.toString())
			.contains("Lee")
			.contains("진")
			.contains(DISTANCE_STR)
			.containsPattern(": -+");
	}

	@Test
	void 우승자_확인() {
		Car lee = racing.getCars().getCarList().get(0);
		lee.go();
		lee.go();
		lee.go();

		Car park = racing.getCars().getCarList().get(1);
		park.go();
		park.go();
		park.go();

		Car kim = racing.getCars().getCarList().get(3);
		kim.go();
		kim.go();

		racing.addWinnerList(3, lee);
		racing.addWinnerList(3, park);
		racing.addWinnerList(3, kim);
		Winners result = racing.getWinner();

		assertThat(result.getCarList())
			.containsOnly(lee, park);
	}

	@Test
	void 우승차_등록() {
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1, 2, 3, 4, 5, 6);

		racing.run();
		racing.audit();

		Winners result = racing.getWinner();
		assertThat(result.toString())
			.contains("제이")
			.contains("논")
			.contains("진");
	}

	@Test
	void 전체_레이싱() {
		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 7, 8, 9);

		racing.setTryCount(new TryCount(3));
		racing.startRacing();

		Winners result = racing.getWinner();
		assertThat(result.toString())
			.contains("제이")
			.contains("논")
			.contains("진");
	}

	@Test
	void 전체_레이싱_유효성검사() {
		racing = new Racing();

		mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
			.thenReturn(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 1, 2, 3, 7, 8, 9);
		racing.setTryCount(new TryCount(3));

		assertThatThrownBy(() -> racing.startRacing())
			.isInstanceOf(IllegalStateException.class)
			.hasMessage(ERROR_NO_CARS);
	}

}
