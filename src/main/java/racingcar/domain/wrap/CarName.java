package racingcar.domain.wrap;

import static racingcar.constants.ErrorMessage.INVALID_CAR_NAME_LENGTH_MESSAGE;

/**
 * @author : choi-ys
 * @date : 2022/04/21 5:53 오후
 */
public class CarName {
    private String name;
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public CarName(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
