package racingcar;

public class CarName {

    public static final int NAME_LENGTH_LIMIT = 5;

    String carName;

    public CarName() {

    }

    public CarName(String s) {
        isCarNameUpperLength(s);

        this.carName = s;
    }


    public void isCarNameUpperLength(String s) {

        if (s.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다.");
        }

    }
}
