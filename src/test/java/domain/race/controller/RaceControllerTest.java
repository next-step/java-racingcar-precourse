package domain.race.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceControllerTest {

    RaceController raceController = new RaceController();

    @Test
    @DisplayName("잘못된 자동차 이름이 입력된 경우")
    void invalidCarNames() {
        String invalidCarNamesFirstComma = ",hello,name";
        String invalidCarNamesLastComma = "hello,name,";
        String invalidOverLength = "hello,congratulation";
        String emptyCarNames = "";

        Assertions.assertThat(raceController.canUseCarNames(invalidCarNamesFirstComma)).isFalse();
        Assertions.assertThat(raceController.canUseCarNames(invalidCarNamesLastComma)).isFalse();
        Assertions.assertThat(raceController.canUseCarNames(invalidOverLength)).isFalse();
        Assertions.assertThat(raceController.canUseCarNames(emptyCarNames)).isFalse();
    }

    @Test
    @DisplayName("5자 길이 이상의 자동차 이름이 입력된 경우")
    void invalidCarNameLength() {
        String overLengthCarNames = "test1,test12,test123";
        Assertions.assertThatThrownBy(()->raceController.allLengthIsLessThanFive(overLengthCarNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 자동차 이름이 입력된 경우")
    void validCarNameLength() {
        String overLengthCarNames = "test,test2,test3";
        Assertions.assertThat(raceController.canUseCarNames(overLengthCarNames)).isTrue();
    }
}