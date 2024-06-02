public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름에는 공백이 포함될 수 없습니다.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영문자만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
