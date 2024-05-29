package io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import model.Car;
import model.RandomDriveCar;

public class Input {

    private static final String INPUT_CARS_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차의 이름은 중복 및 띄어쓰기 없이 영문 5글자 이내여야 합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 " + Integer.MAX_VALUE + " 이하여야 합니다.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("[a-zA-Z]{1,5}");

    public List<Car> inputCars() {
        System.out.println(INPUT_CARS_PROMPT);
        return validateCarNamesAndParse(scanner.nextLine());
    }

    public int inputNumber() {
        System.out.println(INPUT_NUMBER_PROMPT);
        return validateNumberAndParse(scanner.nextLine());
    }

    private static List<Car> validateCarNamesAndParse(String inputString) {
        List<String> inputStringList = Arrays.stream(inputString.split(",")).toList();
        if (!checkEachPattern(inputStringList) || !isDistinct(inputStringList)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
        return inputStringList.stream().map(RandomDriveCar::new).collect(Collectors.toList());
    }

    private int validateNumberAndParse(String inputString) {
        try {
            int inputNumber = Integer.parseInt(inputString);
            if (inputNumber <= 0) {
                throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
            }
            return inputNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static boolean checkEachPattern(List<String> inputStringList) {
        return inputStringList.stream()
            .allMatch(inputString -> CAR_NAME_PATTERN.matcher(inputString).matches());
    }

    private static boolean isDistinct(List<String> inputStringList) {
        return inputStringList.stream().distinct().count() == inputStringList.size();
    }
}
