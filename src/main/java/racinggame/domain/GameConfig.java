package racinggame.domain;

public enum GameConfig {
    START_INCLUSIVE(0),
    END_INCLUSIVE(9),
    ;

    private int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
