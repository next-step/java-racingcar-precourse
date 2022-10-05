package racingcar.model;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.Constants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserTrialRequestTest {


    @ParameterizedTest
    @ValueSource(strings = {"1","2","12","123"})
    @DisplayName("valueOf:[success]")
    void valueOf(String input) {
        //when
        UserTrialRequest trialRequest = UserTrialRequest.valueOf(input);
        //then
        assertThat(trialRequest).isInstanceOf(UserTrialRequest.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"one","two","onetwo","onetwothree"})
    @DisplayName("valueOf (문자 입력 예외):[failure]")
    void valueOf_inputException(String input){
        //when&then
        assertThatThrownBy(()->UserTrialRequest.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COMMON_ERROR_HEADER.concat(ERROR_TRIAL_INPUT));
    }

    @ParameterizedTest
    @CsvSource({"1,1","2,2","12,12","123,123"})
    @DisplayName("getTrial:[success]")
    void getTrial(String input, int expect){
        //when
        UserTrialRequest trialRequest = UserTrialRequest.valueOf(input);
        //then
        assertThat(trialRequest.getTrial()).isEqualTo(expect);
    }
}