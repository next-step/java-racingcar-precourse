
public class Car {
    static final int NAME_LENGTH = 5;
    private String name;
    public Car(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }
}
