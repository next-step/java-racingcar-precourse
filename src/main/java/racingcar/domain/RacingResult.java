package racingcar.domain;

import racingcar.util.Constants;

public class RacingResult {
    private String result;

    public RacingResult() {
        this.result = "";
        addMessage(Constants.RESULT);
        addNewLine();
    }

    public String toString() {
        return result;
    }

    public void addMessage(String msg) {
        this.result += msg;
    }

    public void addNewLine() {
        this.result += Constants.NEWLINE;
    }
}
