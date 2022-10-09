package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;

class CarTest {

    @DisplayName("자동차 이름에 빈 문자열을 입력하면 예외가 발생한다. args={0}")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "  "})
    void constructor_자동차_이름은_NULL이나_빈문자열이면_예외가_발생한다(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름의 길이는 1이상 5이하여야 한다. 그렇지 않으면 예외가 발생한다. args={0}")
    @ParameterizedTest
    @ValueSource(strings = {"666666", "a1b2c3", ""})
    void constructor_자동차_이름의_길이는_1이상_5이하_여야한다_그렇지않으면_예외가_발생한다(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름의 길이가 1이상 5이하면 이름이 잘 부여된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "333", "4444", "55555", "a", "b2", "c33", "d444", "e5555"})
    void constructor_자동차_이름의_길이가_1이상_5이하면_자동차_이름이_부여된다(String name) {
        // when
        Car car = new Car(name);
        // then
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 앞뒤에 빈 문자열이 있으면 예외가 발생한다. args={0}")
    @ParameterizedTest
    @ValueSource(strings = {" hi", "hi ", " hi "})
    void constructor_자동차_이름_앞뒤에_빈문자열이_오면_예외가_발생한다(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 생성되면 초기 위치는 0이다.")
    @Test
    void constructor_자동차_이름_앞뒤에_빈문자열이_오면_예외가_발생한다() {
        // when
        Car car = new Car("hi");
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차가 {0}번 전진하면 {0}만큼 이동한다.")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void go_자동차가_N번_전진하면_자동차의_위치는_N만큼_이동한다(int n) {
        // when
        Car car = new Car("hi");
        for (int i = 0; i < n; i++) {
            car.go();
        }
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(n);
    }

    @DisplayName("자동차가 {0}번 정지하였다면 위치는 계속 기존과 같은 위치여야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "3,1", "10,2"})
    void stop_자동차가_N번_정지하였다면_위치는_계속_기존위치여야한다(int n, int position) throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car = new Car("hi");
        Field field = car.getClass().getDeclaredField("position");
        field.setAccessible(true);
        field.setInt(car, position);
        // when
        for (int i = 0; i < n; i++) {
            car.stop();
        }
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차를 출력할 때 이름과 위치가 함께 표시되어야한다.")
    @ParameterizedTest
    @CsvSource(value = {"hi,0", "hello,1", "world,2", "jdk,5"})
    void toString_자동차를_출력할때_이름과_위치가_함께_표시된다(String name, int position) throws NoSuchFieldException, IllegalAccessException {
        // given
        Car car = new Car(name);
        Field field = car.getClass().getDeclaredField("position");
        field.setAccessible(true);
        field.setInt(car, position);

        long count = car.toString()
                .chars()
                .filter(ch -> ch == Car.POSITION_UNIT)
                .count();

        // when then
        Assertions.assertThat(car.toString()).contains(name);
        Assertions.assertThat(count).isEqualTo(position);
    }
}