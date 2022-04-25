package racingcar.domain;

import racingcar.utils.ValidationUtils;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class Car {
    
    private String inputCarNames;
    private List<String> carNames;
    private boolean isValidCarName;

    public static final String SEPERATOR = ",";

    public Car() {
        newCarName();
    }

    private void newCarName() {
        do {
            inputCarNames = InputView.getInputCarName();
            carNames = Arrays.asList(inputCarNames.split(SEPERATOR));
            isValidCarName = new ValidationUtils(carNames).isValidCarName();
        } while(!isValidCarName);
    }

    public List<String> getCarNames() {
        return carNames;
    }

}
