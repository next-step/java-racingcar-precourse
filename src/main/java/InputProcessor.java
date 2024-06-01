public class InputProcessor {
    private Input input = new Input();
    private Output output = new Output();
    private Rule rule = new Rule();

    public String processCarNames() {
        output.carNameOutput();
        while (true) {
            try {
                String carNameInput = input.carNameInput();
                rule.carNameIsNull(carNameInput);
                rule.carNameIsOverSize(carNameInput);
                return carNameInput;
            } catch (IllegalArgumentException e) {
                output.errorOutput(e.getMessage());
            }
        }
    }

    public int processGameCount() {
        output.tryCntOutput();
        while (true) {
            try {
                String tryCntInput = input.tryCntInput();
                rule.tryCntInputValid(tryCntInput);
                return Integer.parseInt(tryCntInput);
            } catch (IllegalArgumentException e) {
                output.errorOutput(e.getMessage());
            }
        }
    }

}
