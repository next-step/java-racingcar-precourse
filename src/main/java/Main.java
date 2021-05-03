import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarRacing racing = new CarRacing();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCar = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int inputNum = Integer.parseInt(scanner.nextLine());

        System.out.println("car : " + inputCar);
        System.out.println("number : " + inputNum);

        List<Cars> carList = racing.getCars(inputCar, ",");
        List<Cars> finished = racing.racing(carList, inputNum);
        String result = racing.finish(finished);

        System.out.println(result);
    }
}
