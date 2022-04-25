package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Game;
import racingcar.game.RacingCarGame;
import racingcar.global.AppUtils;
import racingcar.host.RacingGameHost;
import racingcar.participant.Participant;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Participant> participantList = enterParticipants();
        Integer numberOfAttempts = enterNumberOfAttempts();
        Game game =  new RacingCarGame(new RacingGameHost(participantList, numberOfAttempts));
        playTheGame(game);
    }

    private static Integer enterNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return AppUtils.readNumberOfAttempts(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterNumberOfAttempts();
        }
    }

    private static List<Participant> enterParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            return AppUtils.readParticipantList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterParticipants();
        }
    }

    private static void playTheGame(Game game) {
        game.start();
        do {
            game.play();
        } while (!game.end());
    }
}
