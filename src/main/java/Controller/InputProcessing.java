package Controller;

import View.RacingViews;
import Model.FindErrors;
import java.util.InputMismatchException;

public class InputProcessing {
    private RacingViews racingViews;
    private FindErrors findErrors;

    public InputProcessing(RacingViews racingViews, FindErrors findErrors) {
        this.racingViews = racingViews;
        this.findErrors = findErrors;
    }

    public String getValidCarNames() {
        while (true) {
            try {
                String carNames = racingViews.getCarNames();
                findErrors.validCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getValidAttempts() {
        while (true) {
            try {
                int attempts = racingViews.getAttempts();
                findErrors.validAttempts(attempts);
                return attempts;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 입력 형식이 올바르지 않습니다. 정수로 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
