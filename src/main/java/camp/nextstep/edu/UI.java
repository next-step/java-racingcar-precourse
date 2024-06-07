package camp.nextstep.edu;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UI {

    private final Scanner scanner;
    private String[] carNames;
    private int repeatCount;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true) {
            String carNames = scanner.nextLine();
            try {
                this.carNames = checkCarNames(carNames);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String[] checkCarNames(String carNames) throws IllegalArgumentException {
        String[] arrNames = carNames.split(",");
        long cnt = Stream.of(arrNames)
                .map(String::trim)
                .filter(this::carNameLengthCheck)
                .count();
        if (cnt == arrNames.length) {
            return arrNames;
        }
        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름 형식을 확인 하세요.");
    }

    public boolean carNameLengthCheck(String s) {
        return !s.isEmpty() && s.length() <= 5;
    }

    public void inputRepeatCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        while (true) {
            int tryCount = scanner.nextInt();
            try {
                this.repeatCount = checkRepeatCount(tryCount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkRepeatCount(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟 수는 0 이상 " + Integer.MAX_VALUE + " 이하 입니다.");
        }
        return n;
    }

    public void run() {
        List<Car> carList = prepareRacingCar(this.carNames);
        race(carList, this.repeatCount);
        printWinner(carList);
    }

    public List<Car> prepareRacingCar(String[] carNames) {
        return Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void race(final List<Car> carList, int raceCount) {
        System.out.println("실행 결과");
        IntStream.range(0, raceCount)
                .forEach(count -> {
                    for (Car c : carList) {
                        c.race();
                        System.out.println(c.racingProgressStatus());
                    }
                    System.out.println();
                });
    }

    public void printWinner(List<Car> carList) {
        // TODO: 경기에 우승한 차량을 stdout에 출력
    }
}
