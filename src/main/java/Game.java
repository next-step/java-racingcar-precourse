import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private final Random rand = new Random(System.currentTimeMillis());
    private Car[] cars;
    private int tryCnt = -1;

    public static void main(String[] args) {
        Game game = new Game();
        game.createCars();
        game.getTryOutNumber();
        System.out.println("실행결과");
        game.playGame();

    }

    public void playGame() {
        for (int i = 0; i < tryCnt; i++) {
            for (Car car : cars) {
                car.run();
            }
            printResult();
        }
    }

    private void printResult() {
        for (Car car : cars) {
            car.printStatus();
        }
        System.out.println();
    }

    public String[] getListOfCars() {
        String[] carList = sc.nextLine().split(",");
        try {
            validateCarListInput(carList);
        } catch (IllegalArgumentException e) {
            carList = getListOfCars();
        }
        return carList;
    }

    private void validateCarListInput(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                System.out.println("[ERROR] 자동차명은 5자를 초과할 수 없습니다");
                throw new IllegalArgumentException();
            }
        }
    }

    public void getTryOutNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryCnt = sc.nextInt();
            sc.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR] 숫자를 입력해주세요");
            sc = new Scanner(System.in);
            getTryOutNumber();
        }
        if (tryCnt < 0) {
            System.out.println("[ERROR] 시도 회수는 양수여야 합니다");
            getTryOutNumber();
        }
    }

    public void createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = getListOfCars();
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim(), rand);
        }
    }
}
