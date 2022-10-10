package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    @DisplayName("레이싱카 이름이 5자리 이하일 때 확인")
    public void 레이싱카_이름_길이_확인() {
        assertThat(ValidationUtils.validCarName("주호세")).isTrue();
    }

    @Test
    @DisplayName("레이싱카 이름이 5자리 넘어갔을 때 확인")
    public void 레이싱카_이름_길이_5자리_넘어감_확인() {
        assertThatThrownBy(() -> ValidationUtils.validCarName("틀린케이스만들기"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationUtils.RACING_CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("레이싱카 이름이 0자리일 때 에러 확인")
    public void 레이싱카_이름_길이_0자리_에러_확인() {
        assertThatThrownBy(() -> ValidationUtils.validCarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationUtils.RACING_CAR_NAME_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값 , 나누기 확인")
    public void inputSplit() {
        List<String> result = ValidationUtils.inputSplit("test1,test2,test3");
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값이 타당한지 확인")
    public void inputError() {
        List<String> testInput = new ArrayList<>();
        testInput.add("");
        boolean result = ValidationUtils.validCarNames(testInput);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("사용자의 자동차 이름 입력값이 타당한지 확인")
    public void inputSuccess() {
        List<String> testInput = new ArrayList<>();
        testInput.add("호세");
        testInput.add("영미");
        boolean result = ValidationUtils.validCarNames(testInput);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("몇 번을 이동할 것인지 입력값 타당한지 확인")
    public void inputGameCount(){
        String testInput = "3";
        assertThat(ValidationUtils.validateGameCount(testInput)).isEqualTo(true);
    }

    @Test
    @DisplayName("몇 번을 이동할 것인지 입력값 이상할 때 에러 확인")
    public void inputGameCountError(){
        String testInput = "가";
        assertThatThrownBy(()-> ValidationUtils.validateGameCount(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationUtils.GAME_COUNT_ERROR_MESSAGE);
    }
}
