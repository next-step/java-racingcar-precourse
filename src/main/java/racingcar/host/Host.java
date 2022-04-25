package racingcar.host;

import racingcar.participant.Participant;

import java.util.List;

public interface Host {

    void play();

    boolean isOver();

    List<Participant> announceTheProgress();

    List<Participant> announceTheWinner();

}
