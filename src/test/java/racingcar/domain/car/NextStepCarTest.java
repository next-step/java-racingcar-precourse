package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static racingcar.Assertions.assertRandomTest;

class NextStepCarTest {

    @Test
    @DisplayName("NextStepCar가 정상 랜덤 값에 에러를 발생시키지 않는지 확인한다.")
    void FUEL_정상_설정_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatCode(
                        () -> {
                            Car car = new NextStepCar("test");
                            car.move();
                        }
                ).doesNotThrowAnyException(),
                9
        );
    }

    @Test
    @DisplayName("NextStepCar가 비정상 랜덤 값에 에러를 발생시키는지 확인한다.")
    void FUEL_비정상_시_에러_발생_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> assertThatThrownBy(
                        () -> {
                            Car car = new NextStepCar("test");
                            car.move();
                        }
                ) .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("랜덤 값의 범위를 벗어났습니다."),
                -1
        );
    }

    @Test
    @DisplayName("NextStepCar가 전진에 따른 차의 위치를 정상적으로 반환하는지 확인한다.")
    void 전진_여부_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () ->  {
                    Car car = new NextStepCar("test");
                    car.move();
                    assertEquals(1, car.getLocation(),"차의 위치는 1이여야 합니다.");
                },
                8
        );
    }

    @Test
    @DisplayName("NextStepCar가 정상적인 이름을 에러없이 처리하는지 확인한다.")
    void 이름_정상_설정_여부_검증() {
        assertThatCode(
                () -> {
                    Car car = new NextStepCar("test");
                }
        ).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("NextStepCar에 비정상적인 이름 설정 시 에러를 발생시키는지 확인한다.")
    void 이름_비정상_시_에러_발생_여부_검증() {
        assertThatThrownBy(
                () -> {
                    Car car = new NextStepCar("carName");
                }
        ) .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름의 길이가 잘못되었습니다.");
    }

    @Test
    @DisplayName("NextStepCar가 자동차의 이름 및 위치 출력을 정상적으로 반환하는지 확인한다.")
    void 출력부_포맷_검증() {
        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    Car car = new NextStepCar("test");
                    car.move();
                    assertEquals("test : -", car.toString(),"출력값이 'test : -'여야 합니다.");
                },
                8
        );
    }

}