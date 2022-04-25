package racingcar.domain;

public class CarName {

    private final String name;

    public CarName(String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }

    private void validate() {
        assert(name != null);
        if(this.name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
