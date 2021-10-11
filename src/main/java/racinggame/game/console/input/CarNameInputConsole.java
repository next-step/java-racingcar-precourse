package racinggame.game.console.input;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameInputConsole extends BaseInputConsole<List<String>> {

    private final int carNameMaxLength;
    private final String carNameDelimiter;


    List<String> carNames = null;

    public CarNameInputConsole(String inputMessage,
                               String errorMessage,
                               int carNameMaxLength,
                               String carNameDelimiter) {
        super(inputMessage, errorMessage);
        this.carNameMaxLength = carNameMaxLength;
        this.carNameDelimiter = carNameDelimiter;
    }

    @Override
    public List<String> getInputValue() {
        boolean doRepeat = true;

        while (doRepeat) {
            super.printInputMessage();
            String inputValue = Console.readLine();
            boolean isValidPolicy = isValidPolicy(inputValue);
            doRepeat = !isValidPolicy;
            super.printErrorMessageIfNotValid(isValidPolicy);
        }

        return this.carNames;
    }

    @Override
    protected boolean isValidPolicy(String inputValue) {
        setCarNames(inputValue);

        if(this.carNames.isEmpty()) {
            return false;
        }
        int invalidNameCount = getInvalidNameCount(this.carNames);
        return invalidNameCount <= 0;
    }
    private void setCarNames(String inputValue) {
        this.carNames = new ArrayList<>();
        this.carNames.addAll(makeCarNames(inputValue));
    }

    private List<String> makeCarNames(String inputValue) {
        List<String> carNames = new ArrayList<>();

        if(!inputValue.contains(carNameDelimiter)) {
            carNames.add(inputValue);
            return carNames;
        }
        String[] splitValue = inputValue.split(carNameDelimiter);
        carNames.addAll(Arrays.asList(splitValue));
        return carNames;
    }

    private int getInvalidNameCount(List<String> carNames) {
        int invalidCount = 0;
        for(String carName: carNames) {
            invalidCount = plusIfInvalid(invalidCount, carName);
        }
        return invalidCount;
    }

    private int plusIfInvalid(int invalidCount, String carName) {
        if(isWhiteSpace(carName)) {
            return invalidCount + 1;
        }
        if(isOverMaxLength(carName)) {
            return invalidCount + 1;
        }
        return invalidCount;
    }

    private boolean isWhiteSpace(String value) {
        return "".equals(value.trim());
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > carNameMaxLength;
    }



}
