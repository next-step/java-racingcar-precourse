package racinggame.console.input;

public abstract class BaseInputConsole<T>{
    private final String inputMessage;
    private final String errorMessage;

    protected BaseInputConsole(String inputMessage, String errorMessage) {
        this.inputMessage = inputMessage;
        this.errorMessage = errorMessage;
    }


    public abstract T getInputValue();
    protected abstract boolean isValidPolicy(String inputValue);

    protected void printInputMessage() {
        System.out.print(inputMessage);
    }

    protected void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            System.out.println(errorMessage);
        }
    }

    protected boolean isBlank(String value) {
        return value == null || "".equals(value.trim());
    }
}
