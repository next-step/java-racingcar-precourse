package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputCarRacingTest {

    private InputCarRacing inputCarRacing = new InputCarRacing();


    @ParameterizedTest
    @DisplayName("입력 받은 차이름이 잘 분리 되는지 확인")
    @ValueSource(strings = "java,is,good")
    void 차_이름_분리_테스트(String carNames) {
        String[] arr = {"java", "is", "good"};
        assertThat(inputCarRacing.spiltCarName(carNames))
                .isEqualTo(arr);
    }


    @ParameterizedTest
    @DisplayName("자동차 이름 인풋에 공백 유뮤에 따른 결과 반환확인")
    @ValueSource(strings = "java, pro, g ram,mer" )
    void 공백시_다시입력_테스트(String str) {

        assertThat(inputCarRacing.validSpaceInName(str)).isFalse();
    }





}
