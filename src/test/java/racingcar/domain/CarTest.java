package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 이름이 5글자 초과된 경우, 오류가 발생한다.")
	void new_FailedByOverNameMaxLength() {
		assertThatThrownBy(() -> {
			new Car("123456");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
	}

	@RepeatedTest(value = 10, name = "0-9 랜덤값 생성 - 실행 횟수 {currentRepetition}/{totalRepetitions}")
	void random1_9() {
		Car car = new Car("pobi");
		assertThat(car.getRandomNo()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
	}

	@Test
	@DisplayName("랜덤 값이 4 이상인 경우 전진한다.")
	void move_forward() {
		Car car = new Car("pobi") {
			@Override
			protected int getRandomNo() {
				return 4;
			}
		};
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤 값이 4 미만인 경우 멈춘다.")
	void move_stop() {
		Car car = new Car("pobi") {
			@Override
			protected int getRandomNo() {
				return 3;
			}
		};
		car.move();
		assertThat(car.getPosition()).isEqualTo(0);
	}
}