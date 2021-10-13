package racinggame;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5글자 이내로 이름을 생성할 수 있습니다.");
        }
    }
}
