package view;

import model.Car;
import model.CarGroup;

import java.util.List;

public class OutputView {

    private static final String PROGRESS_MESSAGE = "실행 결과";
    private static final String RESULT_MESSAGE = "최종 우승자 : ";

    public void printExecutionResultMessage() {
        System.out.println(PROGRESS_MESSAGE);
    }

    public void printProgress(CarGroup carGroup) {
        System.out.println();
        carGroup.getCars().forEach(car -> System.out.println
                (car.getName() + " : " + "-".repeat(car.getPosition())));
    }

    public void printResult(CarGroup carGroup) {
        List<String> winners = getWinners(carGroup);
        if (!winners.isEmpty()) {
            String result = String.join(", ", winners);
            System.out.println(RESULT_MESSAGE + result);
        }
    }

    private List<String> getWinners(CarGroup carGroup) {
        List<Car> cars = carGroup.getCars();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
