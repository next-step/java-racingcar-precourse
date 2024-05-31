package test.java.Model;

import Controller.ValidateInput;
import Model.Car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class InputTest {
    @Test
    @DisplayName("정상적인 자동차 이름을 입력했을 때 예외가 발생하지 않는지 테스트")
    public void validCarTest() {
        assertDoesNotThrow(() -> {
            ValidateInput.validCar("car1", new ArrayList<>());
        });
    }

    @Test
    @DisplayName("자동차 이름을 null일 때 예외가 발생하는지 테스트")
    public void nullTestCar() {
        //given
        String carName = null;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validCar(carName, new ArrayList<>());
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 이름을 입력해주세요!"));
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하일 때 예외를 발생시키는지 테스트")
    public void lengthTest() {
        //given
        List<Car> carList = List.of(new Car("pykido"), new Car("pobipobi"), new Car("animoto"));

        //when
        for (Car car : carList) {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                ValidateInput.validCar(car.getName(), carList);
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
                ValidateInput.validCar(car.getName(), carList);
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
            ValidateInput.validCar("ahri", carList);
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 중복된 이름이 존재합니다!"));
    }

    @Test
    @DisplayName("정상적인 시도 횟수가 입력했을 때 예외가 발생하지 않는지 테스트")
    public void validTryCountTest() {
        assertDoesNotThrow(() -> {
            ValidateInput.validTryCount("5");
        });
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

    @Test
    @DisplayName("시도 횟수에 null값이 입력되었을 때 예외를 발생시키는지 테스트")
    public void nullTestTryCount() {
        //given
        String tryCount = null;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ValidateInput.validTryCount(tryCount);
        });

        //then
        assertTrue(exception.getMessage().contains("[ERROR] 정수값을 입력해야합니다!"));
    }
}
