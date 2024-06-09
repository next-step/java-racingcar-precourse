import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<String> carList;
    static int raceNum;
    static Random random;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        carList = checkCarName(getUserInput(0));

        System.out.println("시도할 회수는 몇회인가요?");
        raceNum = Integer.parseInt(getUserInput(1));

        System.out.println("실행 결과");
        random = new Random();
        for(int i = 0; i < raceNum; i++){
            raceStart(i);
        }

    }

    public static String getUserInput(int inputOrder){ // 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input must be a non-empty string.");
        }
        return input ;
    }

    public static List<String> checkCarName(String input){ // 입력받은 차 이름 반환
        List<String> checkedNames = new ArrayList<>();
        String[] names = input.split(",");

        for (String name : names) {
            if (name.length() <= 5) {
                checkedNames.add(name);
            }
        }
        return checkedNames;
    }

    public static void raceStart(int i){
        int randomNumber = random.nextInt(10);
        

    }
}
