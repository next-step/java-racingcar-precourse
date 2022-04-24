package racingcar.view.userinferface;

public interface GameUserInterface {
    void error(String errorMessage);

    void show(String message);

    String getUserInput(String message);
}
