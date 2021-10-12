package racinggame.model;

public class CarName {

    public static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name){
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
