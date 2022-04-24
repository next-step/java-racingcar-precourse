package racingcar;

import static racingcar.util.MyUtils.repeatBuilder;
import static racingcar.util.MyUtils.retryUntilNotNull;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.racing.Racing;
import racingcar.racing.RacingLine;

public class RacingPlay {


    public void play() {
        List<Car> cars = retryUntilNotNull(this::scanCars);
        Integer maxRound = retryUntilNotNull(this::scanMaxRound);

        Racing racing = Racing.fromCars(cars, maxRound);

        play(racing);

        printFirstCarNames(racing);
    }

    private void play(Racing racing) {
        System.out.println("실행 결과");
        for (int i = 0; i < racing.getMaxRacingRound(); i++) {
            racing.play();
            printPlayingResult(racing);
        }
    }

    private void printFirstCarNames(Racing racing) {
        List<String> firstCarNames = new ArrayList<>();
        for (Car car : racing.getFirstCars()) {
            firstCarNames.add(car.getName());
        }
        System.out.println("최종 우승자: " + String.join(",", firstCarNames));
    }

    private void printPlayingResult(Racing racing) {
        StringBuilder stringBuilder = new StringBuilder();
        for (RacingLine racingLine : racing.getRacingLines()) {
            stringBuilder
                    .append(racingLine.getRacingCarName())
                    .append(" : ")
                    .append(repeatBuilder("-", racingLine.getPosition()))
                    .append('\n');
        }
        System.out.println(stringBuilder);
    }

    private int scanMaxRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private List<Car> scanCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
