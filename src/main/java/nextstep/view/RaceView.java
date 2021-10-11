package nextstep.view;

import nextstep.dto.MoveResult;
import nextstep.dto.RaceResult;
import nextstep.utils.Console;

import java.io.PrintStream;

public class RaceView {

    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRIAL_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
    private static final String NAME_DISTANCE_SPLITTER = " : ";
    private static final String FINAL_WINNER = "최종 우승자는 ";
    private static final String SUFFIX = " 입니다.";

    private static final PrintStream out = System.out;

    public String getNames() {
        out.println(CAR_NAMES_INPUT_MESSAGE);
        return Console.readLine();
    }

    public Integer getRound() {
        out.println(TRIAL_ROUND_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public void displayResult() {
        out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void displayRace(MoveResult result) {
        out.println(result.getName() + NAME_DISTANCE_SPLITTER + result.getDistance());
    }

    public void displayWinner(RaceResult result) {
        out.println(FINAL_WINNER + result.getNames() + SUFFIX);
    }

    public void nextLine() {
        out.println();
    }
}
