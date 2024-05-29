package race.view;

import race.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {}

    // 내부 클래스가 호출될 때, Instance 가 생성된다
    private static class SingletonHelper {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void outputPromptForCarList(List<Car> carList) {
        for (Car car : carList)
            System.out.println(car);
        System.out.println();
    }

    public void outputPromptForWinnerList(List<Car> carList) {
        String winnerNames = carList.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void outputPromptForErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
