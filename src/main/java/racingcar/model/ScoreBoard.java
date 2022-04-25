package racingcar.model;

public class ScoreBoard {

    public static final int NAME = 0;
    public static final int SCORE = 1;
    public static final String CAR_SCORE_DELIMITER = ":" ;
    public static final String SCOREBOARD_DELIMITER = ";" ;
    public static final String DASH = "-" ;
    public static final String CARGAME_DELIMITER = " : " ;

    public static String scoreBoardWithTemplate(String result) {
        String[] scoreList = result.split(SCOREBOARD_DELIMITER);
        StringBuilder sb = new StringBuilder();
        for (String line : scoreList) {
            sb.append(rewriteScoreWithDashForScoreBoard(line)).append("\n");
        }
        return sb.toString();
    }

    private static String rewriteScoreWithDashForScoreBoard(String line) {
        StringBuilder sb = new StringBuilder();
        String[] splitLine = line.split(CAR_SCORE_DELIMITER);
        sb.append(splitLine[NAME]).append(CARGAME_DELIMITER);
        int value = Integer.parseInt(line.split(CAR_SCORE_DELIMITER)[SCORE]);
        for (int loop = 0; loop < value; loop++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
