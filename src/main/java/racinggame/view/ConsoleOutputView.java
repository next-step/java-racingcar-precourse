package racinggame.view;

import racinggame.domain.*;


public class ConsoleOutputView {

    public ConsoleOutputView() {
        System.out.println("실행 결과");
    }

    public void print(final RacingGame game) {
        Cars cars = game.getCars();
        for (Car car : cars.elements()) {
            Name name = car.getName();
            String progressBar = getProgressBar(car);
            System.out.println(name.value() + " : " + progressBar);
        }
        System.out.println();
    }

    private String getProgressBar(final Car car) {
        Distance distance = car.getDistance();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance.value(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}