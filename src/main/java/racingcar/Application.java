package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final CommandLineInterface commandLineInterface = CommandLineInterface.getInstance();
        commandLineInterface.inputCarNames();
        commandLineInterface.inputRound();
        final Race race = Race.getIntance(commandLineInterface.getSeparatedCarnames(), commandLineInterface.getRound());
        race.start();
        race.printResult();

    }
}
