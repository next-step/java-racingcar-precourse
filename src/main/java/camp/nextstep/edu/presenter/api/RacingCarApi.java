package camp.nextstep.edu.presenter.api;

import camp.nextstep.edu.core.Car;
import camp.nextstep.edu.core.RacingResult;
import camp.nextstep.edu.core.service.RacingCarService;
import camp.nextstep.edu.presenter.dto.request.Request;

import java.util.List;

public class RacingCarApi {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private final RacingCarService racingCarService;

    public RacingCarApi(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void registerRacingCars(Request request) {
        List<Car> cars = parseRacingCars(request);
        racingCarService.registerCars(cars);
    }

    public void startRacing(Request request) {
        int racingCount = parseRacingCount(request);
        RacingResult result = racingCarService.runCarRacing(racingCount);
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public List<Car> parseRacingCars(Request request) {
        List<String> racingCars = List.of(request.content().split(","));
        if (racingCars.size() < 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차는 2대 이상이어야 합니다.");
        }
        for (String racingCar : racingCars) {
            if (racingCar.length() > 5) {
                throw new IllegalArgumentException(ERROR_PREFIX + "자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return racingCars.stream().map(Car::new).toList();
    }

    public int parseRacingCount(Request request) {
        int racingCount = Integer.parseInt(request.content());
        if (racingCount < 1) {
            throw new IllegalArgumentException(ERROR_PREFIX + "레이싱 횟수는 1 이상이어야 합니다.");
        }
        return racingCount;
    }
}
