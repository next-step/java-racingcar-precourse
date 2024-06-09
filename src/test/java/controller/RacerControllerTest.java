package controller;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacerControllerTest {
    @Test
    @DisplayName("Controller setUp 메소드 테스트")
    void setUpTest() {
        // given
        RacerController controller = new RacerController();

        // when
        ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUpRacer(getValidNameInputString());
        ThrowableAssert.ThrowingCallable setUpNames = () -> controller.setUpRacer(getValidNamesInputString());

        // then
        assertThatCode(setUpName).doesNotThrowAnyException();
        assertThatCode(setUpNames).doesNotThrowAnyException();
    }

    private String getValidNameInputString() {
        return "pobi  ";
    }

    private String getValidNamesInputString() {
        return "pobi,woni    , jun  ";
    }
}
