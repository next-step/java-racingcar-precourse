package racinggame.game.console.input;

import nextstep.utils.Console;

public class TryInputConsole extends BaseInputConsole<Integer> {

    public TryInputConsole(String inputMessage, String errorMessage) {
        super(inputMessage, errorMessage);
    }

    private boolean isNumber(String value) {
        if(super.isBlank(value)) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getInputValue() {
        String inputValue = null;
        boolean doRepeat = true;

        while (doRepeat) {
            super.printInputMessage();
            inputValue = Console.readLine();
            boolean isValidPolicy = isValidPolicy(inputValue);
            doRepeat = !isValidPolicy;
            super.printErrorMessageIfNotValid(isValidPolicy);
        }
        return Integer.parseInt(inputValue);
    }

    @Override
    protected boolean isValidPolicy(String inputValue) {
        return isNumber(inputValue);
    }
}
