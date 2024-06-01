package io;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Car;

public class Output {

    private static final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 자동차의 이름은 중복 및 띄어쓰기 없이 영문 5글자 이내여야 합니다.";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 " + Integer.MAX_VALUE + " 이하여야 합니다.";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printCarNameErrorMessage() {
        System.out.println(CAR_NAME_ERROR_MESSAGE);
    }

    public void printNumberFormatErrorMessage() {
        System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printResult(Map<String, String> result) {
        result.forEach((name, state) -> System.out.println(name + " : " + state));
        System.out.println();
    }

    public void printWinner(List<Car> carList) {
        System.out.print("최종 우승자 : ");
        String winners = carList.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winners);
    }
}
