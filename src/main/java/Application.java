import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Integer> racingCar = new HashMap<>();  // Key: 자동차 이름, value: 전진 횟수
    public static void main(String[] args) {
        initCar();         // 경주 자동차 이름 입력
        int tNum = tryNum();                // 전진 시도 횟수 입력
        System.out.println("\n실행 결과");
        for(int i=0; i<tNum; i++) {         // 전진 시도 결과 출력
            racingResult();
        }
        printRacingResult();
    }
    public static void initCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = scanner.nextLine().split(",");
        for(String car: input)
            racingCar.put(car, 0);
    }
    public static int tryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
    public static int randNum() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public static void racingResult() {
        for(Map.Entry<String, Integer> car : racingCar.entrySet()) {
            System.out.print(car.getKey() + " : ");
            racingCar.put(car.getKey(), car.getValue()+isForward());
            for(int j=0; j<car.getValue(); j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int isForward() {
        if(randNum() >= 4)
            return 1;
        return 0;
    }
    public static void printRacingResult() {
        System.out.print("최종 우승자 :");
    }
    public static List<String> winner() {
        List<String> keySet = new ArrayList<>(racingCar.keySet());
        Collections.sort(keySet, (o1, o2) -> racingCar.get(o2).compareTo(racingCar.get(o1)));

        int winnerLength = racingCar.get(keySet.get(0));
        int idx = 0;
        while(racingCar.get(keySet.get(++idx)) == winnerLength) {}

        return keySet.subList(0, idx);
    }
}