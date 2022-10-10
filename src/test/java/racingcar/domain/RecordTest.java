package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecordTest {

	@Test
	@DisplayName("레이싱카의 현재 위치와 이름을 저장하는 Record 객체를 생성한다")
	void createResultTest() {
		String name = "haha";
		RacingCar racingCar = new RacingCar(name);
		Record record = Record.from(racingCar);
		assertThat(record.getName()).isEqualTo(racingCar.getName());
		assertThat(record.getPosition().getValue()).isEqualTo(racingCar.getPositionValue());
	}


}