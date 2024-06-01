import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
            racing();
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
        while(true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int n = verify(scanner.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수만 입력이 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 0보다 큰 양수인 정수를 입력하세요.");
            }
        }
    }
    public static int verify(String n) {
        int number = Integer.parseInt(n);
        if(number < 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }
    public static int randNum() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public static void racing() {
        for(String car : racingCar.keySet()) {
            System.out.print(car + " : " + processBar(car) + "\n");
        }
        System.out.println();
    }
    public static String processBar(String car) {
        racingCar.put(car, racingCar.get(car)+isForward());
        String bar = "";
        for(int i=0; i<racingCar.get(car); i++) {
            bar += "-";
        }
        return bar;
    }
    public static int isForward() {
        if(randNum() >= 4)
            return 1;
        return 0;
    }
    public static void printRacingResult() {
        System.out.print("최종 우승자 :");

        List<String> winningCars = new ArrayList<>(winner());
        System.out.print(" " + winningCars.get(0));
        for(int i=1; i<winningCars.size(); i++) {
            System.out.print(", " + winningCars.get(i));
        }
    }
    public static List<String> lineUp() {
        List<String> keySet = new ArrayList<>(racingCar.keySet());
        Collections.sort(keySet, (o1, o2) -> racingCar.get(o2).compareTo(racingCar.get(o1)));
        return keySet;
    }
    public static List<String> winner() {
        List<String> keySet = new ArrayList<>(lineUp());
        int winnerLength = racingCar.get(keySet.get(0));
        int idx = 0;
        while(racingCar.get(keySet.get(++idx)) == winnerLength) {}

        return keySet.subList(0, idx);
    }
}