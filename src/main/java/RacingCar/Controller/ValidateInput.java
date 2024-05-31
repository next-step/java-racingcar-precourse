package Controller;

import Model.Car;

import java.util.List;

public class ValidateInput {
    public static void validCar(String input, List<Car> carList) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] 이름을 입력해주세요!");
        }
        if (input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 5자 이하의 이름을 입력해주세요!");
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백 문자가 포함되어 있습니다!");
        }

        for (int i = 0; i < carList.size() - 1; i++) {
            Car car = carList.get(i);
            if (car.getName().equals(input)) {
                throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다!");
            }
        }
    }

    public static void validTryCount(String tryCountStr) {
        if (tryCountStr == null) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해야합니다!");
        }

        try {
            int tryCount = Integer.parseInt(tryCountStr);
            if (tryCount < 1) {
                throw new IllegalArgumentException("[ERROR] 1 이상의 숫자를 입력해주세요!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해야합니다!");
        }
    }
}
