package racingcar.model.cars.factory;

public class MoveEventValidator {
    private static final MoveEventAnalyzer ANALYZER = MoveEventAnalyzer.getInstance();

    public static void assertValid(int value) {
        MoveEventValidator.assertValidNumberRange(value);
    }

    private static void assertValidNumberRange(int value) {
        if (!MoveEventValidator.isValidNumberRange(value)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidNumberRange(int value) {
        return value >= MoveEventValidator.ANALYZER.getMinNumber()
                && value <= MoveEventValidator.ANALYZER.getMaxNumber();
    }
}
