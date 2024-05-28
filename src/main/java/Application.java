import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Util util = new Util();
        Print print = new Print();
        Scanner sc = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int count = 0;

        while (true) {
            try {
                print.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String[] names = sc.nextLine().split(",");

                util.checkNames(names);

                for (String name : names) {
                    cars.add(new Car(name));
                }

                break;

            } catch (IllegalArgumentException e) {
                print.printError("IllegalArgumentException");
            }
        }

        while (true) {
            try {
                print.print("시도할 회수는 몇회인가요?");
                String num = sc.nextLine();

                util.isNumber(num);

                count = Integer.parseInt(num);

                break;

            } catch (IllegalArgumentException e) {
                print.printError("IllegalArgumentException");
            }
        }

    }

}
