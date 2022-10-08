package racingcar.domain;

public enum DriveStatus {

    DRIVE, STOP;

    public boolean isDrive() {
        return this == DriveStatus.DRIVE;
    }

}
