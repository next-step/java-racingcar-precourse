package com.github.sangholeedev.javaracingcarprecourse.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
	CarName carName;
	final String name = "이름";

	@BeforeEach
	void setUp() {
		carName = new CarName(name);
	}

	@Test
	@DisplayName("자동차이름_생성테스트")
	void 자동차이름_생성테스트() {
		assertThat(carName).isNotNull();
	}

	@Test
	@DisplayName("자동차이름_조회테스트")
	void 자동차이름_조회테스트() {
		assertThat(carName.getName()).isEqualTo(name);
	}

	@Test
	@DisplayName("자동차이름_5자이상_테스트")
	void 자동차이름_5자이상_테스트() {
		assertThatThrownBy(() -> new CarName("이름이5자가넘을때")).isInstanceOf(IllegalArgumentException.class);
	}
}