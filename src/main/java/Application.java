import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] car = namingCar();         // 경주 자동차 이름 입력
        int tNum = tryNum();                // 전진 시도 횟수 입력
        System.out.println("\n실행 결과");
        for(int i=0; i<tNum; i++) {         // 전진 시도 결과 출력
            racingResult(car);
        }
    }
    public static String[] namingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input.nextLine().split(",");
    }
    public static int tryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return input.nextInt();
    }
    public static int randNum() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
    public static void racingResult(String[] carList) {
        for(String car: carList) {
            System.out.print(car + " : ");
            System.out.println();
        }
        System.out.println();
    }
}
