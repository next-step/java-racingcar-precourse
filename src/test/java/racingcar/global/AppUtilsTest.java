package racingcar.global;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.participant.Participant;
import racingcar.participant.RacingCar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AppUtilsTest {

    @DisplayName("경주할 자동차 입력 성공 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {"pobi,crong,honux", "pobi,crong,honux,jun", " "})
    void testRightReadParticipantList(final String enteredString) {
        // Given
        final String[] participantArray = enteredString.split(",");

        // When
        List<Participant> participantList = AppUtils.readParticipantList(enteredString);

        // Then
        for (String participantName : participantArray) {
            Assertions.assertTrue(participantList.contains(new RacingCar(participantName)));
        }
    }

    @DisplayName("경주할 자동차 입력 실패(잘못된 이름) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {",crong,honux", "pobi,,honux", "pobi89,crong,honux", "pobi,crong,honux "})
    void testWrongReadParticipantList(final String enteredString) {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> AppUtils.readParticipantList(enteredString));
    }

    @DisplayName("경주 시도할 횟수 입력 성공 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {"0", "1", "99", "100", "999"})
    void testRightReadNumberOfAttempts(final String enteredString) {
        // Given
        // When
        Integer numberOfAttempts = AppUtils.readNumberOfAttempts(enteredString);

        // Then
        Assertions.assertEquals(Integer.valueOf(enteredString), numberOfAttempts);
    }

    @DisplayName("경주 시도할 횟수 입력 실패(잘못된 입력) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {"test99", "!Asd", "숫자", "여섯번", "two"})
    void testWrongReadNumberOfAttempts(final String enteredString) {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> AppUtils.readNumberOfAttempts(enteredString));
    }

}