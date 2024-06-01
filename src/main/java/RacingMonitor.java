import java.util.Scanner;

public class RacingMonitor {
    static Scanner scanner = new Scanner(System.in);
    public static void enterRacingCars() {
        while(true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            try {
                RacingController.carVerify(scanner.nextLine().split(","));
                return;
            } catch (IllegalStateException e){
                System.out.println("[ERROR] 경주를 시작하려면 2대 이상의 자동차를 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 자동차 이름은 5자를 넘길 수 없습니다.");
            }
        }
    }
    public static int enterTryNum() {
        while(true) {
            System.out.println("시도할 회수는 몇회인가요?");
            try {
                int n = RacingController.verify(scanner.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] int형 정수만 입력이 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1 ~ 2,147,483,647사이의 정수를 입력하세요.");
            }
        }
    }
    public static void startRace(int num){
        System.out.println("\n실행 결과");
        for(int i=0; i<num; i++) {         // 전진 시도 결과 출력
            RacingGame.racing();
        }
    }
    public static void printRacingResult() {
        RacingGame.lineUp();
        System.out.print("최종 우승자 :");
        System.out.print(" " + RacingGame.racingCar.get(0).getName());
        for(int i=1; i<=RacingGame.winner(); i++) {
            System.out.print(", " + RacingGame.racingCar.get(i).getName());
        }
    }
}
