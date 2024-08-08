import java.util.*;

public class Application {
    private static final String SET_CAR_NAMES = "경주할 자동차의 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String QUESTION_MOVE_NUM = "시도할 회수는 몇회인가요?";
    private static final String PLAY_GAME = "\n실행 결과";

    public static void main(String[] args) {
        HashMap<String, Integer> cars = new LinkedHashMap<>();
        setCarNames(cars);

        int moveNum = setMoveNum();

        playGame(cars, moveNum);


    }

    private static void setCarNames (HashMap<String, Integer> cars) {
        System.out.println(SET_CAR_NAMES);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        List<String> carNames = List.of(userInput.split(", "));

        for (String carName: carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[Error] 자동차의 이름은 5자 이내여야 합니다.");
            }

            cars.put(carName, 0);
        }

    }

    private static int setMoveNum () {
        System.out.println(QUESTION_MOVE_NUM);

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private static void playGame (HashMap<String, Integer> cars, int moveNum) {

        System.out.println(PLAY_GAME);

        for (int i = 0; i < moveNum; i ++) {
            checkMove(cars);

            System.out.println();
        }
    }

    private static void checkMove (HashMap<String, Integer> cars) {
        for (Map.Entry<String, Integer> car: cars.entrySet()) {
            if (isMove()) {
                car.setValue(car.getValue() + 1);
            }

            getResults(car);
        }
    }

    private static boolean isMove () {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }

    private static void getResults (Map.Entry<String, Integer> car) {
        System.out.println(car.getKey() + " : " + "-".repeat(car.getValue()));
    }

}
