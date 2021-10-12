package racinggame.game.model.message;

public class RaceResultMessage {
    private final String message;

    public RaceResultMessage(String carName, int forwardMovementCount) {
        StringBuilder stringBuilder = new StringBuilder(carName + " : ");
        for (int i = 0; i < forwardMovementCount; i++) {
            stringBuilder.append("-");
        }
        this.message = stringBuilder.toString();
    }

    public String getMessage() {
        return message;
    }
}
