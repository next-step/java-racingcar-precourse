package racingcar.view;

public enum InputText {
    CAR_NAME("경주할자동차이름(이름은쉼표(,)기준으로구분)"),
    NUMBER_OF_ATTEMPTS("시도할회수");

    private String text;

    InputText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
