import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Application {
    static ArrayList<Car> racingCar = new ArrayList<>();  // Key: 자동차 이름, value: 전진 횟수
    public static void main(String[] args) {
        RacingController.initCar();         // 경주 자동차 이름 입력
        int tNum = RacingController.tryNum();                // 전진 시도 횟수 입력
        System.out.println("\n실행 결과");
        for(int i=0; i<tNum; i++) {         // 전진 시도 결과 출력
            racing();
        }
        printRacingResult();
    }
    public static int randNum() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public static void racing() {
        for(Car car : racingCar) {
            isForward(car);
            System.out.print(car.getName() + " : " + car.getPosition() + "\n");
        }
        System.out.println();
    }
    public static void isForward(Car car) {
        if(randNum() >= 4)
            car.forward();
    }
    public static void printRacingResult() {
        lineUp();
        System.out.print("최종 우승자 :");
        System.out.print(" " + racingCar.get(0).getName());
        for(int i=1; i<=winner(); i++) {
            System.out.print(", " + racingCar.get(i).getName());
        }
    }
    public static void lineUp() {
        Collections.sort(racingCar, (o1, o2) -> o2.getPosition().length() - o1.getPosition().length());
    }
    public static int winner() {
        int winnerLength = racingCar.get(0).getPosition().length();
        int idx = -1;
        while(racingCar.get(++idx).getPosition().length() == winnerLength) {}
        return idx-1;
    }
}