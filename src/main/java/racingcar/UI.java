package racingcar;

import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {
    void start() {
        RaceGame raceGame = enterRacerAndStartGame();

        enterRound(raceGame);

        Race race = raceGame.run();

        printRaceGameResult(raceGame, race);
    }

    private void printRaceGameResult(RaceGame raceGame, Race race) {
        System.out.println("실행 결과");
        for (int i = 1; i <= race.getSize(); i++) {
            Round round = race.getRound(i);
            Set<String> racerNames = round.getRacerNames();
            printRacerDistance(round, racerNames);
            System.out.println();
        }

        System.out.print("최종 우승자 : " + String.join(", ", raceGame.getWinners()));
    }

    private void enterRound(RaceGame raceGame) {
        boolean isUpdateCount = false;
        while (!isUpdateCount) {
            System.out.println("시도할 회수는 몇회인가요?");
            String count = readLine();
            isUpdateCount = setMoveCount(raceGame, count);
        }
    }

    private RaceGame enterRacerAndStartGame() {
        RaceGame raceGame = null;
        while (raceGame == null) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = readLine();
            raceGame = startRaceGame(input);
        }
        return raceGame;
    }

    private void printRacerDistance(Round round, Set<String> racerNames) {
        for (String racerName : racerNames) {
            String distanceStr = new String(new char[round.getDistance(racerName)]).replace("\0", "-");
            System.out.println(racerName + " : " + distanceStr);
        }
    }

    private boolean setMoveCount(RaceGame raceGame, String count) {
        try {
            raceGame.setMoveCount(Integer.parseInt(count));
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return false;
        }
    }

    private RaceGame startRaceGame(String names) {
        try {
            return new RaceGame(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return null;
        }
    }
}
