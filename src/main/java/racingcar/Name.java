package racingcar;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
