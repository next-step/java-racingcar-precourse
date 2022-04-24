package enums;

public enum MovingStatus {
    MOVING_FORWARD, STOP;

    public boolean isMovingForward(){
        return this.equals(MOVING_FORWARD);
    }

    public boolean isStop() {
        return this.equals(STOP);
    }
}
