import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Car> racingCar = new ArrayList<>();  // Key: 자동차 이름, value: 전진 횟수
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
        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            try {
                carVerify(scanner.nextLine().split(","));
                return;
            } catch (IllegalStateException e){
                System.out.println("[ERROR] 경주를 시작하려면 2대 이상의 자동차를 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다.");
            }
        }
    }
    public static void carVerify(String[] carList) {
        if(carList.length <= 1)
            throw new IllegalStateException();
        for(int i=0; i<carList.length; i++) {
            if(carList[i].length() > 5)
                throw new IllegalArgumentException();
        }
        createList(carList);
    }
    public static void createList(String[] carList) {
        for(String car: carList)
            racingCar.add(new Car(car));
    }
    public static int tryNum() {
        while(true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int n = verify(scanner.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] int형 정수만 입력이 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1 ~ 2,147,483,647사이의 정수를 입력하세요.");
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