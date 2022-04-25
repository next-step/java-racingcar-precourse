package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.constant.ErrorMessageConst;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    @Test
    @DisplayName("RacingCar 초기화 테스트: 기본")
    void 초기화_테스트(){
        RacingCar car = new RacingCar("car1");
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("RacingCar 초기화 테스트: 차이름 5자 초과로 오류 발생")
    void 초기화_테스트_오류발생_5자초과(){
        assertThatIllegalArgumentException().isThrownBy(()-> new RacingCar("car123"))
                .withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT, 1, 5));
    }

    @Test
    @DisplayName("RacingCars 초기화 테스트: 차이름 1자 미만으로 오류 발생")
    void 초기화_테스트_오류발생_1자미만(){
        assertThatIllegalArgumentException().isThrownBy(()-> new RacingCar(""))
                .withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_LENGTH_FORMAT, 1, 5));
    }

    @Test
    @DisplayName("RacingCars 초기화 테스트: 차이름 null로 오류 발생")
    void 초기화_테스트_오류발생_null(){
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCar(null))
                .withMessageContaining(ErrorMessageConst.ERROR_MESSAGE_INVALID_CAR_NAME_NULL);
    }

    @ParameterizedTest(name = "전진 테스트 : 입력값 = {0}, 결과 = {1}")
    @DisplayName("전진 테스트")
    @CsvSource(value = {"4:1", "9:1", "0:0", "3:0"}, delimiter = ':')
    void 전진_테스트(int value, int result){
        RacingCar car = new RacingCar("test");
        car.move(value);
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
