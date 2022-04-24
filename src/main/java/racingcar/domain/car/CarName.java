package racingcar.domain.car;

public class CarName {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String CAR_NAME_ERROR = "[ERROR] 차 이름은 1자 이상 5자 이하입니다. ";
    private final String name;


    private CarName(String name) {
        this.name = name;
    }

    /**
     * 생성자
     *
     * @param name 이름
     * @return 이름
     */
    public static CarName of(String name) {
        validateCarName(name);
        return new CarName(name);
    }

    /**
     * validation check 길이와 null
     *
     * @param name 이름
     */
    private static void validateCarName(String name) {

        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH ||
                name.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_ERROR);
        }
    }

    /**
     * car name
     *
     * @return 이름
     */
    public String getCarName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

}
