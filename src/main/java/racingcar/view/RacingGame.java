package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidation;
import racingcar.domain.Player;

import java.util.*;

public class RacingGame {
    private static final RacingGame RACING_GAME = new RacingGame();
    private List<Player> playerList = new ArrayList<>();
    private int gameCount = 0;

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return RACING_GAME;
    }

    public void playRacing() {
        inputPlayer();
        inputGameCount();
        startGame();
    }

    public void inputPlayer() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputPlayerName = Console.readLine();
            String[] players = InputValidation.inputLengthValidation(inputPlayerName);
            for (String name : players) {
                Player player = new Player();
                player.setName(name);
                playerList.add(player);
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            inputPlayer();
        }
    }

    public void inputGameCount() {
        try {
            System.out.println("시도할 회수");
            String inputGameCount = Console.readLine();
            gameCount = InputValidation.inputGameCountValidation(inputGameCount);
        } catch (IllegalArgumentException iae) {
            System.out.println("[ERROR] " + iae.getMessage());
            inputGameCount();
        }
    }

    public void startGame() {
        for (int i = 0; i < gameCount; i++) {
            for (Player plyer : playerList) {
                plyer.plyeGame();
            }
            System.out.println();
        }
    }

}
