package racinggame;

public class RaceManagerGameEndCount {
    private final int gameEndCount;

    public RaceManagerGameEndCount(String gameEndCount) {
        validateNumberGameEndCount(gameEndCount);
        this.gameEndCount = Integer.parseInt(gameEndCount);
    }

    private void validateNumberGameEndCount(String gameEndCount) {
        if (gameEndCount == null) {
            throw new NullPointerException(ErrorMessage.printNotNullEndGamePointMessage());
        }

        if (!isNumber(gameEndCount)) {
            throw new IllegalArgumentException(ErrorMessage.printNotNumberGameEndPointMessage(gameEndCount));
        }
    }

    public int getGameEndCount() {
        return gameEndCount;
    }

    public static boolean isNumber(String number) {
        return number.matches("-?[0-9]+");
    }
}
