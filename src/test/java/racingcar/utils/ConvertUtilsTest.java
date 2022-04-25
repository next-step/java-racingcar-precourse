package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessageConst;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ConvertUtilsTest {
    @Test
    @DisplayName("RepeatCount Convert 테스트: 성공")
    void RepeatCount_Convert_성공(){
        assertThat(ConvertUtils.convertRepeatCountToInteger(String.valueOf(Integer.MIN_VALUE)))
                .isEqualTo(Integer.MIN_VALUE);
        assertThat(ConvertUtils.convertRepeatCountToInteger(String.valueOf(Integer.MAX_VALUE)))
                .isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("RepeatCount Convert 테스트: 실패 - Integer 변환 실패: 최대값 초과")
    void RepeatCount_Convert_실패_최대값_초과(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> ConvertUtils.convertRepeatCountToInteger("123465789123456789")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Convert 테스트: 실패 - Integer 변환 실패: Invalid 문자")
    void RepeatCount_Convert_실패_Invalid_문자(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> ConvertUtils.convertRepeatCountToInteger("abc")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Convert 테스트: 실패 - Empty String")
    void RepeatCount_Convert_실패_Empty_String(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> ConvertUtils.convertRepeatCountToInteger("")).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("RepeatCount Convert 테스트: 실패 - null")
    void RepeatCount_Convert_실패_null(){
        assertThatIllegalArgumentException().isThrownBy(
                ()-> ConvertUtils.convertRepeatCountToInteger(null)).withMessageContaining(
                        String.format(ErrorMessageConst.ERROR_MESSAGE_INVALID_NUMBER_FORMAT)
                );
    }

    @Test
    @DisplayName("Winner Names Convert 테스트: 단독우승")
    void Winnernames_Convert_단독우승(){
        List<String> winnerNames = new ArrayList<>();
        winnerNames.add("car1");
        assertThat(ConvertUtils.convertWinnerNamesListToString(winnerNames)).isEqualTo("car1");
    }

    @Test
    @DisplayName("Winner Names Convert 테스트: 공동우승")
    void Winnernames_Convert_공동우승(){
        List<String> winnerNames = new ArrayList<>();
        winnerNames.add("car1");
        winnerNames.add("car2");
        assertThat(ConvertUtils.convertWinnerNamesListToString(winnerNames)).isEqualTo("car1,car2");
    }

    @Test
    @DisplayName("하이픈 Convert 테스트")
    void 하이픈_Convert_테스트(){
        assertThat(ConvertUtils.convertPositionToHyphenString("5")).isEqualTo("-----");
    }
}
