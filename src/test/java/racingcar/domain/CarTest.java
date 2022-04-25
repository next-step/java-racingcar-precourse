package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:47 오후
 */
@DisplayName("Domain:Car")
public class CarTest {
    private final String carName = "람보르기니";
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("자동차 이름 객체를 가지는 자동차 객체 생성")
    public void createCar() {
        // Then
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getCarName()).isEqualTo(carName)
        );

    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("잘못된 이름 예외 발생 Test")
    public void inValidCarNameTest(String name) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name))
                .withMessageContaining("[ERROR]");
    }

    private static Stream inValidCarNameTest() {
        return Stream.of(
                Arguments.of("람보르기니 우라칸"),
                Arguments.of("")
        );
    }

    @Test
    @DisplayName("생성된 단일 난수 추가 Test")
    public void addRandomNumberTest() {
        // Given
        int randomNumber = 1;

        // When
        car.addNumber(randomNumber);

        // Then
        assertAll(
                () -> assertThat(car.getCarNumbers().getNumbers()).size().isEqualTo(1),
                () -> assertThat(car.getCarNumbers().getNumbers().get(0)).isEqualTo(randomNumber)
        );
    }
}
