package domain;

/**
 * RacingCar의 유효성 검사를 수행합니다. 접근지정자를 default로 설정하여 같은 패키지 내에서만 접근 가능합니다.
 */
class RacingCarValidator {

    /**
     * 이름이 null이거나 비어있는지 검사합니다.
     *
     * @param name 이름
     */
    public static void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    /**
     * 레이싱 횟수가 0보다 작거나 같은지 검사합니다.
     *
     * @param racingCount 레이싱 횟수
     */
    public static void validateRacingCount(int racingCount) {
        if (racingCount <= 0) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야합니다.");
        }
    }
}
