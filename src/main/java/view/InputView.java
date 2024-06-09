package view;

import model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String ERROR_PREFIX = "[Error]";
    private static final int MAX_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Car> getCarNames() {
        List<String> carNames;
        do {
            System.out.println(REQUEST_CAR_NAME);
            String input = scanner.nextLine();
            carNames = Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .toList();
        } while(isError(carNames));

        return carNames.stream().map(Car::new).toList();
    }

    public static int getTryCount() {
        int tryCount;
        while(true) {
            try {
                System.out.println(REQUEST_TRY_COUNT);
                tryCount = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(ERROR_PREFIX + e);
                scanner.next();
            }
        }
        return tryCount;
    }

    private static boolean isError(List<String> carNames) {
        try {
            validateCarName(carNames);
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e);
            System.out.println();
            return true;
        }
        return false;
    }

    private static void validateCarName(List<String> carNames) {
        for(String str : carNames) {
            if(str.length() > MAX_LENGTH || str.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
