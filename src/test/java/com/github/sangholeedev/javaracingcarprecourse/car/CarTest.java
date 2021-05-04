package com.github.sangholeedev.javaracingcarprecourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	@DisplayName("자동차 생성 테스트")
	void 자동차_생성_테스트() {
		final String name = "이름";
		Car car = new Car(name);
		assertThat(car).isNotNull();
	}

}
