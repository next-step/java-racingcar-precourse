package racingcar.type;

public enum CarMovingStatusType {

    NONE,
    MOVING;

    public static boolean isMovingType(CarMovingStatusType carMovingStatusType) {
        return CarMovingStatusType.MOVING.equals(carMovingStatusType);
    }

}
