package racingcar.controller.dto;

public class UserInput {
    private final String names;
    private final String timeStr;

    private UserInput(String names, String timeStr) {
        this.names = names;
        this.timeStr = timeStr;
    }

    public static UserInput of(String names, String timeStr) {
        return new UserInput(names, timeStr);
    }

    public String getNames() {
        return names;
    }

    public String getTimeStr() {
        return timeStr;
    }

}