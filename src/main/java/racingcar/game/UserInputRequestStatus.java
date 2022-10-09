package racingcar.game;

public enum UserInputRequestStatus {
    ON, OFF;

    public boolean isOn() {
        if (this == ON) {
            return true;
        }
        return false;
    }
}
