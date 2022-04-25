package racingcar.host;

import racingcar.global.AppUtils;
import racingcar.global.ValidateUtils;
import racingcar.participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class RacingGameHost implements Host {

    private final List<Participant> participantList;
    private final Integer numberOfAttempts;
    private Integer currentAttempts;
    private Integer currentHighScore;
    private List<Participant> winnerList;


    public RacingGameHost(List<Participant> participantList, Integer numberOfAttempts) {
        ValidateUtils.validateParticipants(participantList);
        ValidateUtils.validateNumberOfAttempts(numberOfAttempts);

        this.participantList = participantList;
        this.numberOfAttempts = numberOfAttempts;
        this.currentAttempts = 0;
        this.currentHighScore = 0;
        this.winnerList = new ArrayList<>();
    }


    @Override
    public void play() {
        validateAttempts();
        for (Participant participant : participantList) {
            participant.process(AppUtils.pickRandomSingleDigit());
            currentHighScore = compareHighScore(currentHighScore, participant.report().length());
        }
        currentAttempts++;
    }

    @Override
    public boolean isOver() {
        return currentAttempts >= numberOfAttempts;
    }

    @Override
    public List<Participant> announceTheProgress() {
        return AppUtils.copyParticipantList(participantList);
    }

    @Override
    public List<Participant> announceTheWinner() {
        winnerList.clear();
        for (Participant participant : participantList) {
            checkParticipantIsHighScorer(participant);
        }

        return AppUtils.copyParticipantList(winnerList);
    }

    private void validateAttempts() {
        if (currentAttempts >= numberOfAttempts) {
            throw new IllegalStateException(String.format(
                    "%s 자동차 게임 시도 최대 횟수값(%d)에 해당하여, 더 이상 게임을 진행할 수 없습니다.",
                    ValidateUtils.ERROR_PREFIX, numberOfAttempts));
        }
    }

    private void checkParticipantIsHighScorer(Participant participant) {
        if (participant.report().length() == currentHighScore) {
            winnerList.add(participant);
        }
    }

    private int compareHighScore(int source, int target) {
        return source > target ? source : target;
    }

}
