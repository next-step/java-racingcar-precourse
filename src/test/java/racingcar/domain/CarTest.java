package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @ParameterizedTest(name = "자동차 생성")
    @ValueSource(strings = {"abcde", "1234", "일이삼사오"})
    void 자동차_생성(String input) {
        // when
        Car car = new Car(input);
        // then
        assertThat(car.getName()).isEqualTo(new Name(input));
        assertThat(car.getDistance()).isEqualTo(new Distance());
    }

    @ParameterizedTest(name = "자동차 이름이 같을 경우 같은 객체")
    @CsvSource({
            "abcde, abcde"
            , "12345, 12345"
    })
    void 자동차_객체_같음_비교(String input1, String input2) {
        // when
        Car car1 = new Car(input1);
        Car car2 = new Car(input2);
        // then
        assertThat(car1.equals(car2)).isTrue();
    }

    @ParameterizedTest(name = "자동차 이름이 다를 경우 다른 객체")
    @CsvSource({
            "abced, xyz"
            , "12345, 0987"
    })
    void 자동차_객체_다름_비교(String input1, String input2) {
        // when
        Car car1 = new Car(input1);
        Car car2 = new Car(input2);
        // then
        assertThat(car1.equals(car2)).isFalse();
    }
}