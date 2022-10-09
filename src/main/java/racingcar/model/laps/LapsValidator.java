package racingcar.model.laps;

public class LapsValidator {
    public static final LapsAnalyzer ANALYZER = LapsAnalyzer.getInstance();

    public static void assertValid(int laps) {
        LapsValidator.assertValid(String.valueOf(laps));
    }

    public static void assertValid(String laps) throws NumberFormatException, IllegalArgumentException {
        LapsValidator.assertValidNumberFormat(laps);
        LapsValidator.assertValidNumberRange(laps);
    }

    private static void assertValidNumberFormat(String laps) {
        if (!LapsValidator.isNumberFormat(laps)) {
            throw new NumberFormatException();
        }
    }

    private static void assertValidNumberRange(String laps) {
        if (!LapsValidator.isValidNumberRange(laps)) {
            throw new IllegalArgumentException();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static boolean isNumberFormat(String laps) {
        try {
            Integer.parseUnsignedInt(laps);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidNumberRange(String laps) {
        long inputCharNumber = Long.parseLong(laps);
        return inputCharNumber >= LapsValidator.ANALYZER.getMinValue()
                && inputCharNumber <= LapsValidator.ANALYZER.getMaxValue();
    }
}
