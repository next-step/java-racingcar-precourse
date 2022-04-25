package racingcar.model.primitive;

public class Name {
    private String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이는 5 이하");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}