package racinggame.model.enums;

public enum MoveAction {
    GO, STOP;

    public boolean isGo() {
        return this == GO;
    }
}
