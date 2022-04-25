package racingcar;

public class CommandCount {

    private final int commandCount;

    public CommandCount(String commandCount) {
        try {
            this.commandCount = Integer.parseInt(commandCount);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(ErrorMessage.COMMAND_COUNT_ERROR);
        }
    }

    public int getCommandCount() {
        return commandCount;
    }

}
