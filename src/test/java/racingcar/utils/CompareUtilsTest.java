package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompareUtilsTest {

    @Test
    @DisplayName("최대 Integer 조회 Util 테스트")
    void getLargestIntegerTest() {
        // given
        List<Integer> integerList = new ArrayList<>();
        int expectedLargestInteger = 10;

        integerList.add(expectedLargestInteger);
        integerList.add(expectedLargestInteger - 1);
        integerList.add(expectedLargestInteger - 2);

        // when
        int largestInteger = CompareUtils.getLargestInteger(integerList);

        //then
        assertThat(largestInteger).as("Integer 리스트 중 최대 숫자가 기대한 값과 일치하는지 확인")
                .isEqualTo(expectedLargestInteger);
    }

    @ParameterizedTest(name = "양의 정수 여부 테스트 [input : {0}, 양의 정수 여부 : {1}]")
    @CsvSource(value = {
            ",false",
            "' ',false",
            "some string,false",
            "-1,false",
            "0,false",
            "0.123,false",
            "1,true",
            "100,true",
    })
    void isPositiveNumberTest(String input, boolean expectedResult) {
        // when
        boolean isPositiveInteger = CompareUtils.isPositiveInteger(input);

        //then
        assertThat(isPositiveInteger).as("기대 결과와 일치여부 확인")
                .isEqualTo(expectedResult);
    }
}