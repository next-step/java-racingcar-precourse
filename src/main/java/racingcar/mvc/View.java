package racingcar.mvc;

import racingcar.mvc.domain.ScoreBoard;
import racingcar.utils.ArrayUtil;

import java.util.ArrayList;

public class View {

    private final static String SCORE_BAR = "-";
    private final static String ERROR_PREFIX = "[ERROR]";

    public static void renderScoreBoard(ScoreBoard scoreBoard) {
        for (String playerName : scoreBoard.keyset()) {
            renderPlayerScore(playerName, scoreBoard.getScore(playerName));
        }
    }

    public static void renderPlayerScore(String playerName, Integer score) {
        System.out.println(playerName + " : " + scoreToString(score, SCORE_BAR));
    }

    public static void renderWinners(String[] names) {
        System.out.println("최종 우승자는 " + String.join(", ", ArrayUtil.toArrayList(names)) + " 입니다.");
    }

    public static void renderException(Exception e, Integer trialNumber) {
        System.out.println(ERROR_PREFIX + e.getMessage() + "(시도횟수 : " + trialNumber + ")");
    }


    private static String scoreToString(Integer score, String text) {
        ArrayList<String> textList = new ArrayList<>();
        for (int k = 0; k < score; k++) {
            textList.add(text);
        }
        return String.join("", textList);
    }
}
