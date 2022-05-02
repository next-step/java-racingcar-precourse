package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Cars {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 0;
    public static final String CAR_INPUT_MSG = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로구분)";
    public static final String MAX_LENGTH_ERROR_MSG = "[ERROR] 자동차이름이 5자 이상입니다.";
    public static final String MIN_LENGTH_ERROR_MSG = "[ERROR] 자동차이름이 0자 입니다.";

    public static String[] inputCars() {
        System.out.println(CAR_INPUT_MSG);
        String carName = Console.readLine();
        return carName.split(",");
    }

    public static boolean checkInput(String[] cars) throws IllegalArgumentException {
        try {
            checkLength(cars);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void checkLength(String[] cars) throws IllegalArgumentException {
        for(String carName : cars) {
            if(carName.length() > MAX_LENGTH) {
                throw new IllegalArgumentException(MAX_LENGTH_ERROR_MSG);
            } else if(carName.length() == MIN_LENGTH) {
                throw new IllegalArgumentException(MIN_LENGTH_ERROR_MSG);
            }
        }
    }
}
