package racingcar.feature;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameTest {
    Exception exception = new Exception();

    @DisplayName("자동차 이름 - 생성")
    @Test
    void createCarNameTest() {
        //given:
        String input = "ming,inni,hyun";
        //when:
        List<CarName> carNameList = CarName.makeCarName(input);
        //then:
        assertThat(carNameList)
                .isNotEmpty()
                .hasSize(3);
    }

    @DisplayName("자동차 이름 - 예외 - 공백이 포함 된 자동차 이름 입력")
    @Test
    void spaceOrEmptyCarNameTest() {
        //given:
        String input = " ,ming";
        //when:
        try {
            CarName.makeCarName(input);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        //then:
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 공백이 포함되지 않은 자동차 이름을 입력");
    }

    @DisplayName("자동차 이름 - 예외 - 5글자를 초과한 자동차 이름 입력")
    @Test
    void overFiveCharacterTest() {
        //given:
        String input = "mingble,ming";
        //when:
        try {
            CarName.makeCarName(input);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        //then:
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5글자보다 작아야 한다");
    }

    @DisplayName("자동차 이름 - 예외 - 1대 이하의 자동차 이름 입력")
    @Test
    void onlyOneCarTest() {
        //given:
        String input = "ming";
        //when:
        try {
            CarName.makeCarName(input);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        //then:
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 2대 이상의 자동차");
    }

    @DisplayName("자동차 이름 - 예외 - 자동차 이름 중복 입력")
    @Test
    void duplicatedCarNameTest() {
        //given:
        String input = "ming,ming";
        //when:
        try {
            CarName.makeCarName(input);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
        //then:
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복 된 자동차 이름");
    }
}
