import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner scanner ;
    static List<String> carList ;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        getCarList();

        System.out.println("시도할 회수는 몇회인가요?");
        int raceNum = getRaceNum();

        // int raceNum = Integer.parseInt(scanner.nextLine());
        System.out.println();

        CarRaceModel model = new CarRaceModel(carList);
        CarRaceView view = new CarRaceView();
        CarRaceController controller = new CarRaceController(model, view);
        controller.startRace(raceNum);
    }

    public static List<String> getCarList(){
        carList = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine().trim();

            try {
                validateInput(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return carList ;
    }

    public static List<String> checkCarName(String input) { // 입력받은 차 이름 반환
        List<String> checkedNames = new ArrayList<>();
        String[] names = input.split(",");

        for (String name : names) {
            if (name.length() <= 5) {
                checkedNames.add(name);
            }
        }
        return checkedNames;
    }

    private static void validateInput(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("빈 자동차 이름이 있습니다.");
            }
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            carList.add(name);
        }
    }

    public static int getRaceNum(){
        int raceNum ;
        while (true) {
            try {
                raceNum = scanner.nextInt();                
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                scanner.nextLine();
            }
        }
        return raceNum;
    }
}
