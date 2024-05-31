import static org.junit.jupiter.api.Assertions.*;

import DTO.Car;
import Util.Util;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    Util u = new Util();

    @Test
    @DisplayName("자동차명 검증(참)")
    void TrueCheckNames() {
//        given
        String[] test = {"123", "456", "789"};
//        when

//        then
        assertDoesNotThrow(() -> {
            u.checkNames(test);
        });
    }


    @Test
    @DisplayName("자동차명 검증(오류)")
    void FalseCheckNames() {
//        given
        String[] test = {"", "123456", "123456789"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.checkNames(test);
        });
    }

    @Test
    @DisplayName("자동차명 검증(빈칸)")
    void BlankCheckNames() {
//        given
        String[] test = {" 123","4 5 6","789"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.checkNames(test);
        });
    }

    @Test
    @DisplayName("자동차명 검증(중복)")
    void DuplicateCheckNames() {
//        given
        String[] test = {"123","123"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.checkNames(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(참)")
    void TrueIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "100";

//        when

//        then
        assertDoesNotThrow(() -> {
            u.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(오류)")
    void FalseIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "test";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(소수)")
    void FloatIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "3.141592";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(오버플로우)")
    void OverflowIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "2147483648";

//        when

//        then
        assertThrows(IllegalStateException.class, () -> {
            u.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(음수)")
    void NegativeIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "-100";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            u.isNumber(test);
        });
    }

    @Test
    @DisplayName("0~9사이 값인지 검증")
    void generateRandomNumber() {
//        given
        int random = u.generateRandomNumber();

//        when

//        then
        assertTrue(random >= 0 && random <= 9);
    }

    @Test
    @DisplayName("가장 멀리간 자동차 이름 array로 반환")
    void printWinner() {
//        given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));

//        when
//        test1,test2가 3칸씩 나가고, test3은 0칸 나아감
        cars.get(0).updateNum(5);
        cars.get(0).updateNum(5);
        cars.get(0).updateNum(5);

        cars.get(1).updateNum(5);
        cars.get(1).updateNum(5);
        cars.get(1).updateNum(5);

//        then
        String[] answer = {"test1", "test2"};
        assertArrayEquals(u.printWinner(cars),answer);
    }
}