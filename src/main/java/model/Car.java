package model;

import static controller.GameController.DEL;

import java.util.List;

public class Car {

    private final String name;
    private int count;
    public static final int MAX_LENGTH_NAME = 5;
    public static final int MAX_CARS = 10;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void move() {
        this.count += 1;
    }

    public static void isValidCarNames(String s, List<String> carNames) {
        checkCarNameLength(s); //차 이름은 1~5자
        checkDuplicatedName(s, carNames); //차 이름 중복 불가
    }

    public static void checkCarsCount(List<String> carNames) {
        if (carNames.size() < 2 || carNames.size() > MAX_CARS) {
            throw new IllegalArgumentException("[ERROR] 입력 가능한 이름의 개수는 2~10개 입니다.");
        }
    }

    public static void checkDuplicatedName(String s, List<String> carNames) {
        if (carNames.contains(s)) {
            throw new IllegalArgumentException("[ERROR] 차 이름을 중복되게 입력할 수 없습니다.");
        }
    }

    public static void checkContainedEmpty(String input) {
        if (input.startsWith(DEL) || input.endsWith(DEL) || input.contains(DEL + DEL)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 양식입니다.");
        }
    }

    public static void checkCarNameLength(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하로 가능합니다.");
        }
    }

}
