import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCar = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = scanner.nextLine();

        System.out.println("car : " + inputCar);
        System.out.println("number : " + inputNum);
    }
}
