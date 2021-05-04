package com.gotgolem.racingcar.asset;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DrivingTest {

	@DisplayName("생성 성공 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
	public void createSuccess(final int drivingNumber) {
		assertThatCode(() -> new Driving(drivingNumber))
				.doesNotThrowAnyException();
	}

	@DisplayName("생성 실패 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-99, -30, -1, 10, 11, 100})
	public void createFail(final int drivingNumber) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Driving(drivingNumber));
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	public void move(final int drivingNumber) {
		final Driving driving = new Driving(drivingNumber);
		assertThat(driving.isMove())
				.isTrue();
		assertThat(driving.isStop())
				.isFalse();

	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	public void stop(final int drivingNumber) {
		final Driving driving = new Driving(drivingNumber);
		assertThat(driving.isStop())
				.isTrue();
		assertThat(driving.isMove())
				.isFalse();
	}

}
