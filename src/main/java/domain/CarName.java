package domain;

public class CarName {
    private String name;

    public CarName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘어서는 안됩니다.");
        }

        this.name = name;
    }
}
