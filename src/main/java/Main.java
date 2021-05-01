import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Game game;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        // 이름 입력 받기
        List<String> names = carNamesSetUp();

        // 골 숫자 세팅
        goalSetUp();

        // car 세팅
        List<Car> cars = carSetUp(names);

        // 경주 실행
        play(cars);
    }

    public static List<String> carNamesSetUp() {
        List<String> names = new ArrayList<>();

        while (names.size() < 1) {
            names = inputCarNames(names);
        }
        return names;
    }

    public static List<String> inputCarNames(List<String> names) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = scanner.nextLine();

        // 이름 나누기
        try {
            names = Utils.splitInputCarNames(inputNames);
            carNamesValid(names);
            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void carNamesValid(List<String> names) {
        // 입력 된 자동차 개수 확인
        Utils.inputCarSizeValid(names);

        // 중복된 이름있는지 확인
        Utils.inputCarNameDuplicateValid(names);
    }

    public static boolean resultCheck(List<Car> cars) {
        List<Car> goalStatusCars = Utils.getCarStatusEqualsGoal(cars);

        if (goalStatusCars.size() > 0) {
            printResult(goalStatusCars);
            return true;
        }

        return false;
    }

    public static List<Car> carSetUp(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static void goalSetUp() {
        boolean end = false;
        while (!end) {
            end = inputGoal();
        }
    }

    public static boolean inputGoal() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            Scanner scanner = new Scanner(System.in);
            int goal = scanner.nextInt();
            game = new Game(goal);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void play(List<Car> cars) {
        System.out.println("실행 결과");
        boolean end = false;
        while (!end) {
            racing(cars);
            printCarStatus(cars);
            // 결과 확인
            end = resultCheck(cars);
        }
    }

    public static void racing(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Utils.generatorRandomNumber();
            car.setCarStatus(Utils.getCarStatus(randomNumber));
        }
    }

    public static void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printBar(car.getMoveCount().getCount());
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    public static void printBar(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    public static void printResult(List<Car> goalStatusCar) {
        for (int i = 0; i < goalStatusCar.size(); i++) {
            System.out.print(goalStatusCar.get(i).getName());
            printComma(goalStatusCar, i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printComma(List<Car> goalStatusCar, int index) {
        if (index != goalStatusCar.size() - 1) {
            System.out.print(", ");
        }
    }
}
