package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

class RacingCarsTest {

	@Test
	@DisplayName("레이싱카들의 이름을 입력받아 레이싱카들을 생성한다.")
	void createRacingCarsTest() {
		RacingCars racingCars = RacingCars.of("haha,hihi,hoho");
		assertThat(racingCars.getRacingCars()).hasSize(3);
		assertThat(racingCars.getRacingCars()).containsExactly(
			new RacingCar("haha"),
			new RacingCar("hihi"),
			new RacingCar("hoho")
		);
	}

	@Test
	@DisplayName("입력받은 레이싱카들의 이름에 쉼표(,)가 없으면 예외를 발생시킨다.")
	void createRacingCarsExceptionTest() {
		assertThatThrownBy(() -> RacingCars.of("haha hihi hoho"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("입력받은 레이싱카들의 이름이 공백이거나 null 이면 예외를 발생시킨다.")
	void createRacingCarsEmptyExceptionTest(String name) {
		assertThatThrownBy(() -> RacingCars.of(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("중복된 이름이 있으면 예외를 발생시킨다.")
	void createRacingCarsDuplicateExceptionTest() {
		assertThatThrownBy(() -> RacingCars.of("haha,haha,hoho"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("이동 전략이 true 일 경우 모든 레이싱카들을 이동시킨다.")
	void moveRacingCarsTest() {
		RacingCars racingCars = RacingCars.of("haha,hihi,hoho");
		racingCars.move(() -> true);
		racingCars.getRacingCars().forEach(racingCar ->
			assertThat(racingCar.getPositionValue()).isEqualTo(1));
	}

	@Test
	@DisplayName("이동 전략이 false 일 경우 모든 레이싱카들을 이동시키지 않는다.")
	void notMoveRacingCarsTest() {
		RacingCars racingCars = RacingCars.of("haha,hihi,hoho");
		racingCars.move(() -> false);
		racingCars.getRacingCars().forEach(racingCar ->
			assertThat(racingCar.getPositionValue()).isZero());
	}

	@Test
	@DisplayName("레이싱카들의 현재 이름과 위치를 갖는 Records 객체를 생성한다.")
	void createRecordsTest() {
		RacingCars racingCars = RacingCars.of("haha,hihi");
		Records records = racingCars.getRecords();
		List<Record> recordList = records.getRecordList();
		assertThat(recordList).hasSize(2);
		assertThat(recordList.get(0).getName()).isEqualTo("haha");
		assertThat(recordList.get(0).getPosition().getValue()).isZero();

		racingCars.move(() -> true);
		Records records1 = racingCars.getRecords();
		List<Record> recordList1 = records1.getRecordList();
		assertThat(recordList1.get(0).getPosition().getValue()).isEqualTo(1);
	}
}