package com.github.sangholeedev.javaracingcarprecourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	final String name = "이름";
	Car car;

	@BeforeEach
	void 초기자동차_세팅() {
		car = new Car(name);
	}

	@Test
	@DisplayName("자동차 생성 테스트")
	void 자동차_생성_테스트() {
		final String name = "이름";
		Car car = new Car(name);
		assertThat(car).isNotNull();
	}

	@Test
	@DisplayName("자동차_출력_테스트")
	void 자동차_출력_테스트() {
		assertThat(car.print()).isEqualTo(name);
	}

	@Test
	@DisplayName("자동차_이름_5자이하_테스트")
	void 자동차_이름_5자이하_테스트() {
		assertThatThrownBy(() -> new Car("이름이5자가넘을때")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("자동차_전진_멈춤_테스트")
	void 자동차_전진_멈춤_테스트() {
		assertThat(car.drive()).isEqualTo(car.getRandomNumber().isGreaterThanOrEqualTo4() ? CarDrivenStatus.GO : CarDrivenStatus.STOP);
	}
}
