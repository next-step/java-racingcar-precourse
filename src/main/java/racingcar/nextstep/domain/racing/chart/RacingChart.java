package racingcar.nextstep.domain.racing.chart;

import racingcar.nextstep.domain.car.Car;
import racingcar.nextstep.global.message.TextMessage;

public class RacingChart {


    private final Car car;
    private final String result;

    public RacingChart(Car car, String result) {
        this.car = car;
        this.result = result;
    }

    public Car getCar() {
        return car;
    }

    public String getResult() {
        return result;
    }

    public static RacingChart of(Car car, String result) {
        return new RacingChart(car, result);
    }

    public String result() {
        return car.getCarName().getValue() + TextMessage.COLON + result;
    }

}
