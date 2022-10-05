package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserCarRacingRequestTest {

    @Test
    @DisplayName("valueOfTest:[success]")
    void valueOf() {
        //given
        String str = "Avent, Tusca, Boxst";
        //when
        UserCarRacingRequest userCarRacingRequest = UserCarRacingRequest.valueOf(str);
        //then
        assertThat(userCarRacingRequest).isInstanceOf(UserCarRacingRequest.class);
    }

    @Test
    void getCarNameArray() {
        //given
        String str = "Avent,Tusca,Boxst";
        //when
        UserCarRacingRequest userCarRacingRequest = UserCarRacingRequest.valueOf(str);
        //then
        assertThat(userCarRacingRequest.getCarNameArray()).containsExactly("Avent", "Tusca", "Boxst");
    }
}