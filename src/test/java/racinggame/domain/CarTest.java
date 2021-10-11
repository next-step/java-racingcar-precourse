package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	private Name name;
	private Car car;

	@BeforeEach
	void setUp() {
		name = Name.of("abcde");
		car = Car.of(name);
	}

	@DisplayName("자동차 생성 및 초기위치 확인")
	@Test
	void create() {
		assertThat(car.getName().getValue()).isEqualTo("abcde");
		assertThat(car.getPosition().getValue()).isEqualTo(0);
	}

	@DisplayName("4이상일 때 전진하는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void move(int value) {
		car.move(value);
		assertThat(car.getPosition().getValue()).isEqualTo(1);
	}

	@DisplayName("3이하일 때 멈추는지 확인")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void stop(int value) {
		car.move(value);
		assertThat(car.getPosition().getValue()).isEqualTo(0);
	}
}
