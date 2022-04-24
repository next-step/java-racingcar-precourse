package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.configuration.ErrorMessage.ERR_CAR_NAME_LENGTH_LIMIT_MSG;
import static racingcar.configuration.ErrorMessage.ERR_CAR_POSITION_LIMIT_MSG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.configuration.DirectionStatus;
import racingcar.model.Car;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hobi");
    }

    @Test
    @DisplayName("차량_이름_설정")
    void 차량_이름_등록() {
        assertThat(car.getName()).isEqualTo("hobi");
    }

    @ParameterizedTest(name = "차량_이름_5자이내_Valid_확인")
    @ValueSource(strings = {"1f123f123f", "3434fq", "zcxv211", "   ", ""})
    void 차량_이름_5자이내_Valid_확인(final String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_CAR_NAME_LENGTH_LIMIT_MSG);
    }

    @ParameterizedTest(name = "차량_전진_여부_판단")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 차량_전진_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.MOVE_FORWARD);
    }

    @ParameterizedTest(name = "차량_멈춤_여부_판단")
    @ValueSource(ints = {0, 1, 2, 3})
    void 차량_멈춤_여부_판단(int position) {
        car.setPosition(position);
        DirectionStatus status = car.getStatus();
        assertThat(status).isEqualTo(DirectionStatus.STOP);
    }

    @Test
    @DisplayName("차량_현재_위치_출력_전진")
    void 차량_현재_위치_출력_전진() {
        car.setPosition(6);
        assertThat(car.getScoreLine()).isEqualTo("-");
    }

    @Test
    @DisplayName("차량_현재_위치_출력_멈춤")
    void 차량_현재_위치_출력_멈춤() {
        car.setPosition(3);
        assertThat(car.getScoreLine()).isEqualTo("");
    }

    @Test
    @DisplayName("차량_현재_이름_위치_출력_전진")
    void 차량_실행_결과_출력_전진() {
        car.setPosition(6);
        assertThat(car.getResult()).isEqualTo("hobi : -");
    }

    @Test
    @DisplayName("차량_현재_이름_위치_출력_멈춤")
    void 차량_실행_결과_출력_멈춤() {
        car.setPosition(3);
        assertThat(car.getResult()).isEqualTo("hobi : ");
    }

    @Test
    @DisplayName("차량_현재_이름_위치_출력_전진")
    void 여러번_차량_실행_결과_출력_전진() {
        int matchCnt = 5;
        for (int i = 0; i < matchCnt; i++) {
            car.setPosition(6);
        }
        assertThat(car.getResult()).isEqualTo("hobi : -----");
    }

    @Test
    @DisplayName("차량_현재_이름_위치_출력_멈춤")
    void 여러번_차량_실행_결과_출력_멈춤() {
        int matchCnt = 5;
        for (int i = 0; i < matchCnt; i++) {
            car.setPosition(3);
        }
        assertThat(car.getResult()).isEqualTo("hobi : ");
    }

    @Test
    @DisplayName("차량_현재_이름_위치_출력_혼합")
    void 차량_현재_이름_위치_출력_혼합() {
        int[] positionArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int pos : positionArr) {
            car.setPosition(pos);
        }
        assertThat(car.getResult()).isEqualTo("hobi : ------");
    }

    @Test
    @DisplayName("차량_위치_입력_0부터_9까지_여부_TRUE")
    void 차량_위치_입력_0부터_9까지_여부_TRUE() {
        int[] positionArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        car.setPosition(1);

    }

    @ParameterizedTest(name = "차량_위치_입력_0부터_9까지_여부")
    @ValueSource(ints = {10, -2, 11, 24, 4545, 10000, Integer.MAX_VALUE})
    void 차량_위치_입력_0부터_9까지_여부(final int position) {
        assertThatThrownBy(() -> {
            car.setPosition(position);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_CAR_POSITION_LIMIT_MSG);
    }
}
