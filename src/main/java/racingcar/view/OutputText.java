package racingcar.view;

public enum OutputText {
    WINNER("최종 우승자 : ");

    private String text;

    OutputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
