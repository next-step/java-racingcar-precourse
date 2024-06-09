import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import raceCar.model.Car;
import raceCar.model.RaceCourse;

public class RaceCourceTest {

	@Test
	@DisplayName("트랙 정보 확인")
	void givenTrackInfo_whenCreateRaceCourse_thenSuccess() {
		// given
		Map<Car, Integer> track = new HashMap<>();
		// when
		RaceCourse raceCourse = RaceCourse.of(track);
		// then
		assertThat(raceCourse.getTrack()).isEqualTo(track);
	}

	@Test
	@DisplayName("차량 등록")
	void givenCar_whenAddCar_thenSuccess() {
		// given
		Map<Car, Integer> track = new HashMap<>();
		RaceCourse raceCourse = RaceCourse.of(track);
		Car car = Car.of("yoon");
		// when
		raceCourse.addCar(car);
		// then
		assertThat(raceCourse.getTrack().containsKey(car)).isTrue();
	}

	@Test
	@DisplayName("차량 등록 후 트랙 정보 확인")
	void givenCar_whenAddCar_thenTrackInfo() {
		// given
		Map<Car, Integer> track = new HashMap<>();
		RaceCourse raceCourse = RaceCourse.of(track);
		Car car = Car.of("yoon");
		// when
		raceCourse.addCar(car);
		// then
		assertThat(raceCourse.getTrack().get(car)).isEqualTo(0);
	}
}
