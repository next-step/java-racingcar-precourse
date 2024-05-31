package test.java.Model;

import Controller.ValidateInput;
import Model.Car;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InputTest {
    @Test
    @DisplayName("자동차 이름이 5자 이하일 때 예외를 발생시키는지 테스트")
    public void lengthTest() {
        //given
        List<Car> carList = List.of(new Car("pykido"), new Car("pobipobi"), new Car("animoto"));

        //when
        for (Car car : carList) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                ValidateInput.validaCar(car.getName(), carList);
            });
            //then
            assertTrue(exception.getMessage().contains("[ERROR] 5자 이하의 이름을 입력해주세요!"));
        }
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어 있을 때 예외를 발생시키는지 테스트")
    public void blankTest() {
        //given
        List<Car> carList = List.of(new Car("bo b"), new Car("ha nk"));

        // when
        for (Car car : carList) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                ValidateInput.validaCar(car.getName(), carList);
            });
            //then
            assertTrue(exception.getMessage().contains("[ERROR] 공백 문자가 포함되어 있습니다!"));
        }
    }

    @Test
    @DisplayName("자동차 이름이 중복되었을 때 예외를 발생시키는지 테스트")
    public void duplicateTest() {
        //given
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pyobi"));
        carList.add(new Car("ahri"));

        //when
        carList.add(new Car("ahri"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validaCar("ahri", carList);
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 중복된 이름이 존재합니다!"));
    }

    @Test
    @DisplayName("시도 횟수가 1 미만일 때 예외를 발생시키는지 테스트")
    public void under1Test() {
        //given
        String tryCount = "0";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validTryCount(tryCount);
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 1 이상의 숫자를 입력해주세요!"));
    }

    @Test
    @DisplayName("시도 횟수에 정수값이 아닌 값이 입력되었을 때 예외를 발생시키는지 테스트")
    public void integerTest() {
        //given
        String tryCount = "a";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validTryCount(tryCount);
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 정수값을 입력해야합니다!"));
    }
}
