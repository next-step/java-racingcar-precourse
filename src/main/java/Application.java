import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String[] car = namingCar();    // 경주 자동차 이름 입력
        int tNum = tryNum();           // 전진 시도 횟수 입력
    }
    public static String[] namingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input.nextLine().split(",");
    }
    public static int tryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        return input.nextInt();
    }
}
