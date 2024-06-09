package domain;

public record RacingCarName(String carName){
    private static final int CAR_NAME_LENGTH_MAX = 5;

    public RacingCarName {
        isCarNameLengthValidate(carName);
    }

    private void isCarNameLengthValidate(final String carName){
        if (carName.isEmpty() || carName.length() > CAR_NAME_LENGTH_MAX){
            throw new IllegalArgumentException("racing car 이름은 1자리이상 5자 이하만 가능합니다.");
        }
    }
}
