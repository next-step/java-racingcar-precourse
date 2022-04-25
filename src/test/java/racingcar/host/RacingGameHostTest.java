package racingcar.host;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.global.AppUtils;
import racingcar.global.ValidateUtils;
import racingcar.participant.Participant;
import racingcar.participant.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameHostTest {

    @DisplayName("자동차 경주 주최자 생성 실패(참가자 null) 테스트")
    @Test
    void testRacingGameHostEnterNullParticipantList() {
        // Given
        List<Participant> participantList = null;
        final Integer numberOfAttempts = 5;

        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> new RacingGameHost(participantList, numberOfAttempts));
    }

    @DisplayName("자동차 경주 주최자 생성 실패(자동차 게임 시도 횟수값 null) 테스트")
    @Test
    void testRacingGameHostEnterNullNumberOfAttempts() {
        // Given
        List<Participant> participantList = createParticipants(3);
        final Integer numberOfAttempts = null;

        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> new RacingGameHost(participantList, numberOfAttempts));
    }

    @DisplayName("자동차 경주 주최자 생성 실패(자동차 게임 시도 횟수값 음수) 테스트")
    @Test
    void testRacingGameHostEnterNegativeNumberOfAttempts() {
        // Given
        List<Participant> participantList = createParticipants(3);
        final Integer numberOfAttempts = -1;

        // When
        // Then
        assertThrows(IllegalArgumentException.class, () -> new RacingGameHost(participantList, numberOfAttempts));
    }

    @DisplayName("자동차 경주 주최자 생성 실패(자동차 게임 시도 횟수값 음수) 테스트")
    @ParameterizedTest(name = "{index}. {displayName} 입력값={0}")
    @ValueSource(ints = {0, 1, 10, 15})
    void testRacingGameHostPlayMoreThanNumberOfAttempts(final int numberOfAttempts) {
        // Given
        List<Participant> participantList = createParticipants(3);

        // When
        RacingGameHost racingGameHost = new RacingGameHost(participantList, numberOfAttempts);
        for (int i = 0; i < numberOfAttempts; i++) {
            racingGameHost.play();
        }

        // Then
        assertTrue(racingGameHost.isOver());
        assertThrows(IllegalStateException.class, () -> racingGameHost.play());
    }

    @DisplayName("자동차 경주 주최자 프로세스 검증 테스트")
    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void testRacingCarProcessProperly(RepetitionInfo repetitionInfo) {
        // Given
        int numberOfParticipants = Randoms.pickNumberInRange(0, 8);
        List<Participant> participantList = createParticipants(numberOfParticipants);
        final Integer numberOfAttempts = AppUtils.pickRandomSingleDigit();

        // When
        RacingGameHost racingGameHost = new RacingGameHost(participantList, numberOfAttempts);
        for (int i = 0; i < numberOfAttempts; i++) {
            racingGameHost.play();
        }

        // Then
        assertTrue(racingGameHost.isOver());
        assertThrows(IllegalStateException.class, () -> racingGameHost.play());

        List<Participant> winnerList = racingGameHost.announceTheWinner();
        assertTrue(winnerList.size() <= participantList.size());

        if (numberOfParticipants == 0) {
            return;
        }

        Integer highScore = winnerList.get(0).report().length();
        for (Participant winner : participantList) {
            checkHighScoreIsRight(highScore, winner);
        }
    }

    private void checkHighScoreIsRight(Integer highScore, Participant participant) {
        if (participant.report().length() > highScore) {
            throw new IllegalStateException(String.format(
                    "%s 자동차 경주 최고 점수가 잘못되었습니다. 최고 점수: %d, 참가자: %s",
                    ValidateUtils.ERROR_PREFIX, participant));
        }
    }

    private List<Participant> createParticipants(int numberOfParticipants) {
        List<Participant> participantList = new ArrayList<>();
        for (int i = 0; i < numberOfParticipants; i++) {
            participantList.add(new RacingCar("참가자" + (i + 1) + "번"));
        }
        return participantList;
    }

}