package racingcar;

/**
 * author : citizen103
 */
public class CarName {

    private final String name;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
