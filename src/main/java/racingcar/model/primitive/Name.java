package racingcar.model.primitive;

public class Name {

    private final String name;

    public Name(String value) {
        if(value.length() > 5) {
            throw new IllegalArgumentException("[ERROR]: 이름 길이는 5자를 넘을 수 없습니다.");
        }
        this.name = value;
    }

    public String getName() {
        return name;
    }
}
