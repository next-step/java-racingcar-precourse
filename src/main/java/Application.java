import java.util.Random;
import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] car = namingCar();         // 경주 자동차 이름 입력
        int[] racing = new int[car.length]; // 자동차별 전진 상황 기록 리스트
        int tNum = tryNum();                // 전진 시도 횟수 입력
        System.out.println("\n실행 결과");
        for(int i=0; i<tNum; i++) {         // 전진 시도 결과 출력
            racingResult(car, racing);
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
    public static void racingResult(String[] carList, int[] racingList) {
        for(int i=0; i<carList.length; i++) {
            System.out.print(carList[i] + " : ");
            racingList[i] += isForward();
            for(int j=0; j<racingList[i]; j++) {
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
}
