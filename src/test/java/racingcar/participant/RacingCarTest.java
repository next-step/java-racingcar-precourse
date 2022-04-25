package racingcar.participant;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.AppUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarTest {

    private static RacingCar racingCar;
    private static Integer racingCarLocation;


    @BeforeAll
    static void setup() {
        racingCar = new RacingCar("테스트용");
        racingCarLocation = 0;
    }


    @DisplayName("자동차 생성 성공(이름 길이) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {"jun", "나", "lozms", "lozm ", " lozm", "lj"})
    void testRacingCarEnterRightNameLengthValue(final String enteredString) {
        // Given
        // When
        RacingCar racingCar = new RacingCar(enteredString);

        // Then
        assertEquals(enteredString.trim(), racingCar.getName());
    }

    @DisplayName("자동차 생성 실패(이름 길이) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(strings = {"", "잘못된자동차", " wrong", "wrong "})
    void testRacingCarEnterWrongNameLengthValue(final String enteredString) {
        // Given
        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(enteredString));
    }

    @DisplayName("자동차 전진/멈춤 진행 검증 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void testRacingCarProcessProperly(RepetitionInfo repetitionInfo) {
        // Given
        final int randomSingleDigit = AppUtils.pickRandomSingleDigit();

        // When
        boolean moveForward = racingCar.process(randomSingleDigit);
        racingCarLocation += moveForward ? 1 : 0;
        String reportedLocation = AppUtils.reportDashString(racingCarLocation);

        // Then
        assertEquals(checkMoveForward(randomSingleDigit), moveForward);
        assertEquals(reportedLocation, racingCar.report());
    }

    @DisplayName("자동차 전진/멈춤 진행 성공 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5 ,6 ,7 ,8, 9})
    void testRacingCarProcessRightRandomNumber(final int randomNumber) {
        // Given
        // When
        RacingCar testRacingCar = new RacingCar("테스트용");

        // Then
        boolean moveForward = testRacingCar.process(randomNumber);
        assertEquals(checkMoveForward(randomNumber), moveForward);
    }

    @DisplayName("자동차 전진/멈춤 진행 실패(잘못된 숫자 입력) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(ints = {-1, 10, 11})
    void testRacingCarProcessWrongRandomNumber(final int randomNumber) {
        // Given
        // When
        RacingCar testRacingCar = new RacingCar("테스트용");

        // Then
        assertThrows(IllegalArgumentException.class, () -> testRacingCar.process(randomNumber));
    }

    private boolean checkMoveForward(int randomSingleDigit) {
        return 4 <= randomSingleDigit;
    }

}