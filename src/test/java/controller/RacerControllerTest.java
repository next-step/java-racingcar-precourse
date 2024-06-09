package controller;

import entity.Racer;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacerControllerTest {
    @Test
    @DisplayName("Controller setUpRacer 메소드 성공 테스트")
    void setUpRacerTest() {
        // given
        RacerController controller = new RacerController();

        // when
        ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUpRacer(getValidNameInputString());
        ThrowableAssert.ThrowingCallable setUpNames = () -> controller.setUpRacer(getValidNamesInputString());

        // then
        assertThatCode(setUpName).doesNotThrowAnyException();
        assertThatCode(setUpNames).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Controller setUpRacer 메소드 실패 테스트")
    void setUpRacer_WillThrownTest() {
        // given
        RacerController controller = new RacerController();
        List<String> invalidNameInputStringList = Arrays.asList(null, "   ", "", getInvalidNameInputString());

        for (String invalidNameInputString : invalidNameInputStringList) {
            // when
            ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUpRacer(invalidNameInputString);

            // then
            assertThatThrownBy(setUpName)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }

    private String getValidNameInputString() {
        return "pobi  ";
    }

    private String getValidNamesInputString() {
        return "pobi,woni    , jun  ";
    }

    private String getInvalidNameInputString() {
        return "pobi, ";
    }
}
