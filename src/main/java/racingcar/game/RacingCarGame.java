package racingcar.game;

import racingcar.host.Host;
import racingcar.participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {

    private final Host host;


    public RacingCarGame(Host host) {
        this.host = host;
    }


    @Override
    public void start() {
        System.out.println("실행 결과");
    }

    @Override
    public void play() {
        host.play();
        List<Participant> participantList = host.announceTheProgress();
        for (Participant participant : participantList) {
            System.out.println(String.format("%s : %s", participant.getName(), participant.report()));
        }
        System.out.println();
    }

    @Override
    public boolean end() {
        if (host.isOver()) {
            List<Participant> winnerList = host.announceTheWinner();
            String winners = printWinners(winnerList);
            System.out.println(winners);
            return true;
        }
        return false;
    }

    private String printWinners(List<Participant> winnerList) {
        if (winnerList.size() == 0) {
            return "";
        }
        List<String> winnerNameList = new ArrayList<>();
        for (Participant participant : winnerList) {
            winnerNameList.add(participant.getName());
        }
        return String.format("최종 우승자: %s", String.join(", ", winnerNameList));
    }

    @Override
    public boolean restart(String enteredString) {
        throw new UnsupportedOperationException();
    }

}
