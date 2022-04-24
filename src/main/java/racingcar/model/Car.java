package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    private static final int USERNAME_LENGTH_LIMIT = 5;
    private static final int DRIVE_CRITERIA = 4;

    private final String name;
    private final StringBuilder progressBar;
    private int position;

    public Car(String name) {
        if (StringUtils.isBlank(name)) {
            System.out.println("[ERROR] 이름이 입력되지 않았습니다.");
            throw new IllegalArgumentException("[ERROR] 이름이 입력되지 않았습니다.");
        }

        if (name.length() > USERNAME_LENGTH_LIMIT) {
            System.out.println("[ERROR] 이름이 5자를 초과했습니다.");
            throw new IllegalArgumentException("[ERROR] 이름이 5자를 초과했습니다.");
        }

        this.name = name;
        this.progressBar = new StringBuilder();
    }

    public void drive(int random) {
        if (random >= DRIVE_CRITERIA) {
            progressBar.append('-');
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + progressBar;
    }
}
