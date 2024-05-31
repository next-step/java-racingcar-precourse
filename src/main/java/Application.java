import java.util.Scanner;

public class Application {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        namingCar();    // 경주 자동차 이름 입력
    }
    public static String[] namingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input.nextLine().split(",");
    }
}
