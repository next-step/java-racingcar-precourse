package racingcar.entity;

public class CarName {
    private String name;

    private final String STR_ERR_NULL_MSG = "[ERROR] 문자열이 null 입니다.";
    private final String STR_ERR_LENGTH_MSG = "[ERROR] 자동차 이름의 길이는 5자 이하만 가능합니다.";

    public CarName(String name) {
        setName(name);
    }

    public void setName(String name) {
        checkVaildName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkVaildName(String name) {
        if (name == null) throw new IllegalArgumentException(STR_ERR_NULL_MSG);
        if (name.length() > 5) throw new IllegalArgumentException(STR_ERR_LENGTH_MSG);
    }
}
