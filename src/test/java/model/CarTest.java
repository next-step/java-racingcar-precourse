package model;

import static org.assertj.core.api.Assertions.*;

import exception.NameLengthException;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.InputValidator;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("이름 저장 및 조회 확인")
    public void checkGetterSetter() {
        car.setName("Pobi");

        assertThat(car.getName()).isEqualTo("Pobi");
    }

    @Test
    @DisplayName("자동차 전진 기능 확인")
    public void move() {
        car.setPosition(1);
        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 이름 5자 넘어가는 경우 false 반환 확인")
    public void checkNameLength() {
        List<String> names = Arrays.asList("abcdef", "kakao");
        boolean result = InputValidator.checkNameLength(names);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("자동차 이름 중복된 경우 false 반환 확인")
    public void checkDuplicatedName() {
        List<String> names = Arrays.asList("kakao", "kakao");
        boolean result = InputValidator.checkDuplicatedName(names);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("시도 횟수 1보다 작은 경우 false 반환 확인")
    public void checkAttemptSize() {
        boolean result = InputValidator.checkAttemptSize("-1");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("시도 횟수 정수가 아닌 경우 false 반환 확인")
    public void checkInvalidAttempt() {
        boolean result = InputValidator.checkValidAttempt("aa");
        assertThat(result).isFalse();
    }
}
