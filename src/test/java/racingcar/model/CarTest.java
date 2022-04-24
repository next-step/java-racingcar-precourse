package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.CustomUtils.stringSplitByComma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("단일 자동차 생성 테스트")
    @Test
    void inputSingleCarNameTest() {
        String input = "test";

        Car singleCar = new Car(input);

        assertThat(singleCar.getName()).isEqualTo(input);
    }

    @DisplayName("2대 이상의 자동차 생성 테스트")
    @Test
    void inputMultiCarNameTest() {
        String input = "test1, test2, test3";

        String[] carNames = stringSplitByComma(input);

        for (String carName : carNames) {
            Car car = new Car(carName);

            assertThat(car.getName()).isEqualTo(carName);
        }
    }

    @DisplayName("자동차 이름 5글자 이상인 경우 에러 발생")
    @Test
    void carNameOver5Character() {
        String input = "test555";

        assertThatThrownBy(() -> {
            Car car = new Car(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 최대 5자 까지 가능하다.");

    }

    @DisplayName("전진 조건 결과 확인")
    @Test
    void moveForwardTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("test");
                    car.runRound();
                    assertThat(car.getPosition()).isEqualTo(1);
                },
                4
        );
    }

    @DisplayName("멈추는 조건 결과 확인")
    @Test
    void stopRoundTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("test");
                    car.runRound();
                    assertThat(car.getPosition()).isEqualTo(0);
                },
                3
        );
    }

}